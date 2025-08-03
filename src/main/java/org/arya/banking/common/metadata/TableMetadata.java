package org.arya.banking.common.metadata;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document("tableMetaData")
public class TableMetadata {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field("modelName")
    private String modelName;

    @Field("description")
    private String description;

    @Field("schemaHash")
    private String schemaHash;

    @Field("isLatest")
    private boolean isLatest;

    @Field("columnMetadata")
    private List<ColumnMetadata> columnMetadata;

    @Field("version")
    private String version;

    @Field("createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Field("updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
