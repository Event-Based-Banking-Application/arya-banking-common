package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(LocalDateTime auditTime) {
        this.auditTime = auditTime;
    }
}
