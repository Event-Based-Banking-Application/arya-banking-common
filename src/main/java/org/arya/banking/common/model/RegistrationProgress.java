package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "registration_progress")
@TrackMetadata(name = "Registration Progress", description = "Used to track the registration progress of the user")
public class RegistrationProgress {

    @Id
    private String id;

    @NotNull
    @Field("userId")
    private String userId;

    @NotNull
    @Field("subStatus")
    private String subStatus;

    @NotNull
    @Field("status")
    private String status;

    @NotNull
    @Field("lastStepCompleted")
    private String lastStepCompleted;

    @NotNull
    @Field("nextStep")
    private String nextStep;

    @CreatedDate
    @Field("createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updatedAt")
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(String subStatus) {
        this.subStatus = subStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastStepCompleted() {
        return lastStepCompleted;
    }

    public void setLastStepCompleted(String lastStepCompleted) {
        this.lastStepCompleted = lastStepCompleted;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
