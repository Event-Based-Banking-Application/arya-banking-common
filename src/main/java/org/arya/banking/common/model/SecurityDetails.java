package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Document(collection = "security_details")
@TrackMetadata(name = "Security Details", description = "Stores information about the security details of the user")
public class SecurityDetails extends AryaBase {

    @Id
    private String id;

    @NotNull
    @Field("securityQuestions")
    private List<SecurityQuestions> securityQuestions;

    @NotNull
    @Field("twoFactorEnabled")
    private Boolean twoFactorEnabled;

    @NotNull
    @Field("isEmailVerified")
    private Boolean isEmailVerified;

    @NotNull
    @Field("isContactNumberVerified")
    private Boolean isContactNumberVerified;

    @NotNull
    @Field("loginFailedAttempts")
    private Integer loginFailedAttempts;
}
