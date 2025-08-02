package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SecurityQuestions> getSecurityQuestions() {
        return securityQuestions;
    }

    public void setSecurityQuestions(List<SecurityQuestions> securityQuestions) {
        this.securityQuestions = securityQuestions;
    }

    public Boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public Boolean getContactNumberVerified() {
        return isContactNumberVerified;
    }

    public void setContactNumberVerified(Boolean contactNumberVerified) {
        isContactNumberVerified = contactNumberVerified;
    }

    public Integer getLoginFailedAttempts() {
        return loginFailedAttempts;
    }

    public void setLoginFailedAttempts(Integer loginFailedAttempts) {
        this.loginFailedAttempts = loginFailedAttempts;
    }
}
