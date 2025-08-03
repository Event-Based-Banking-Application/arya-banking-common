package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "registration_progress")
@TrackMetadata(name = "Registration Progress", description = "Used to track the registration progress of the user")
public class RegistrationProgress extends AryaBase {

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
}
