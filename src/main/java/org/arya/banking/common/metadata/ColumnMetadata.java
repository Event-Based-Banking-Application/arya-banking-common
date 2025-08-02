package org.arya.banking.common.metadata;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ColumnMetadata {

    @Field("columnName")
    private String columnName;

    @Field("dataType")
    private String dataType;

    @Field("isPrimary")
    private boolean isPrimaryKey;

    @Field("isNullable")
    private boolean isNullable;

    @Field("defaultValue")
    private Object defaultValue;

    @Field("description")
    private String description;

    @Field("validationRules")
    private Map<String, Object> validationRules;

    @Field("createdAt")
    @CreatedDate
    private LocalDateTime createdAt;

    @Field("updatedAt")
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
