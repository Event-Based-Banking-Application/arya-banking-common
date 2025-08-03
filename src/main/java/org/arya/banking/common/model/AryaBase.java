package org.arya.banking.common.model;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@TrackMetadata(name = "AryaBase", description = "Acts as base model for all existing models")
public abstract class AryaBase {

    @Field(value = "deleted")
    private Boolean deleted = false;

    @CreatedDate
    @Field("createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updatedAt")
    private LocalDateTime updatedAt;
}
