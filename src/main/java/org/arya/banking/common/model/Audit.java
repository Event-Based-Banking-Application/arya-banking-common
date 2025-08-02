package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "audit")
@TrackMetadata(name = "Audit", description = "Stores audit information of all the functionalities")
public class Audit {

    @Id
    private String id;

    @NotNull
    @Field("actionType")
    private String actionType;

    private String targetTable;

    @NotNull
    @Field("targetId")
    private String targetId;

    @NotNull
    @Field("userId")
    private String userId;

    @NotNull
    @Field("changeType")
    private String changeType;

    @NotNull
    @Field("description")
    private String description;

    @CreatedDate
    private LocalDateTime auditTime;
}
