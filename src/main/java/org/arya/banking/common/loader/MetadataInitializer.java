package org.arya.banking.common.loader;

import jakarta.annotation.PostConstruct;
import org.arya.banking.common.metadata.ColumnMetadata;
import org.arya.banking.common.metadata.TableMetadata;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.arya.banking.common.repository.TableMetadataRepository;
import org.arya.banking.common.utils.MetaDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.annotation.Id;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

@Component
public class MetadataInitializer {

    private static final Logger log = LoggerFactory.getLogger(MetadataInitializer.class);

    private final TableMetadataRepository tableMetadataRepository;
    private final MetaDataUtils metaDataUtils;

    private static final String BASE_MODEL_PACKAGE = "org.arya.banking.common.model";

    public MetadataInitializer(TableMetadataRepository tableMetadataRepository) {
        this.tableMetadataRepository = tableMetadataRepository;
        this.metaDataUtils = new MetaDataUtils();
    }

    @PostConstruct
    public void initializeMetadata() {

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(TrackMetadata.class));

        Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents(BASE_MODEL_PACKAGE);

        for (BeanDefinition beanDefinition : beanDefinitions) {

            try {
                Class<?> modelClass = Class.forName(beanDefinition.getBeanClassName());
                processMetadata(modelClass);

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void processMetadata(Class<?> modelClass) {

        TrackMetadata trackMetadata = modelClass.getAnnotation(TrackMetadata.class);
        if (null == trackMetadata) return;

        String modelName = trackMetadata.name();
        log.info("Processing {} model", modelName);

        List<ColumnMetadata> columnMetadatas = new ArrayList<>();
        StringBuilder schemaBuilder = new StringBuilder();

        for (Field field : modelClass.getDeclaredFields()) {

            String columnName = field.getName();
            String dataType = field.getType().getSimpleName();
            boolean isPrimaryKey = null != field.getAnnotation(Id.class);
            boolean isNullable = null != field.getAnnotation(Nullable.class);

            ColumnMetadata columnMetadata = new ColumnMetadata();
            columnMetadata.setColumnName(columnName);
            columnMetadata.setDataType(dataType);
            columnMetadata.setPrimaryKey(isPrimaryKey);
            columnMetadata.setNullable(isNullable);
            columnMetadata.setValidationRules(metaDataUtils.extractValidationRules(field));
            columnMetadatas.add(columnMetadata);

            schemaBuilder.append(columnName).append(":")
                    .append(dataType).append(":")
                    .append(isPrimaryKey).append(":")
                    .append(isNullable).append(":")
                    .append(columnMetadata.getValidationRules().toString());

        }

        String schemaHash = metaDataUtils.generateHash(schemaBuilder.toString());

        Optional<TableMetadata> optionalTableMetadata = tableMetadataRepository.findByModelName(modelName);
        TableMetadata tableMetadata = null;

        if (optionalTableMetadata.isEmpty()) {
            tableMetadata = new TableMetadata();
            tableMetadata.setModelName(modelName);
            tableMetadata.setDescription(trackMetadata.description());
            tableMetadata.setSchemaHash(schemaHash);
            tableMetadata.setLatest(true);
            tableMetadata.setColumnMetadata(columnMetadatas);
            tableMetadata.setVersion("1.0.0");
            log.info("Table Metadata: {}", tableMetadata);
        } else if (!optionalTableMetadata.get().getSchemaHash().equals(schemaHash)) {

            String newVersion = metaDataUtils.generateVersion(columnMetadatas, tableMetadata.getColumnMetadata(), tableMetadata.getVersion(), tableMetadata.getSchemaHash(), schemaHash);
            tableMetadata.setVersion(newVersion);
            tableMetadata.setSchemaHash(schemaHash);
            tableMetadata.setColumnMetadata(columnMetadatas);
            tableMetadata.setLatest(true);
            log.info("Updated the TableMetaData: {}", tableMetadata);
        } else {
            log.info("Schema remains unchanged for: {}, no update is required", modelName);
            return;
        }
        tableMetadataRepository.save(tableMetadata);
    }
}
