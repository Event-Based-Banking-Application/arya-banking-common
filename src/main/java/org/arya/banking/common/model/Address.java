package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "address")
@TrackMetadata(name = "Address", description = "Stores the addresses of the users")
public class Address {

    @Id
    private String id;

    @NotNull
    @Field("street")
    @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]{3,100}$")
    private String street;

    @NotNull
    @Field("city")
    @Pattern(regexp = "^[a-zA-Z\\s.'-]{2,50}$")
    private String city;

    @NotNull
    @Field("state")
    @Pattern(regexp = "^[a-zA-Z\\s.'-]{2,50}$")
    private String state;

    @NotNull
    @Field("zipCode")
    @Pattern(regexp = "^[a-zA-Z0-9\\s-]{3,15}$")
    private String zipCode;

    @NotNull
    @Field("country")
    @Pattern(regexp = "^[a-zA-Z\\s.'-]{2,56}$")
    private String country;

    @NotNull
    @Field("isPrimary")
    private boolean isPrimary;

    @CreatedDate
    @Field("createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Field("updatedAt")
    private LocalDateTime updatedAt;


    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        this.isPrimary = primary;
    }
}
