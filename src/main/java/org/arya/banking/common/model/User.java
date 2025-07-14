package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "user")
@TrackMetadata(name = "User", description = "Stores information about the User")
public class User {

    @Id
    private String id;

    @NotNull
    @Field("firstName")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String firstName;

    @NotNull
    @Field("lastName")
    @Pattern(regexp = "^[A-Za-z]+$")
    private String lastName;

    @NotNull
    @Field("emailId")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    private String emailId;

    @NotNull
    @Field("contactNumberIds")
    private List<String> contactNumberIds;

    @NotNull
    @Field("addressIds")
    private List<String> addressIds;

    @NotNull
    @Field("primaryAddressId")
    private String primaryAddressId;

    @NotNull
    @Field("status")
    private String status;

    @NotNull
    @Field("roleId")
    private String roleId;

    @NotNull
    @Field("securityDetailId")
    private String securityDetailId;

    @Field("createdAt")
    private LocalDateTime createdAt;

    @Field("updatedAt")
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public List<String> getContactNumberIds() {
        return contactNumberIds;
    }

    public void setContactNumberIds(List<String> contactNumberIds) {
        this.contactNumberIds = contactNumberIds;
    }

    public List<String> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(List<String> addressIds) {
        this.addressIds = addressIds;
    }

    public String getPrimaryAddressId() {
        return primaryAddressId;
    }

    public void setPrimaryAddressId(String primaryAddressId) {
        this.primaryAddressId = primaryAddressId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getSecurityDetailId() {
        return securityDetailId;
    }

    public void setSecurityDetailId(String securityDetailId) {
        this.securityDetailId = securityDetailId;
    }
}
