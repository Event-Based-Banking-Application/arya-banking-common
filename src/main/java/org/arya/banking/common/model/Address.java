package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@TrackMetadata(name = "Address", description = "Stores the addresses of the users")
public class Address {

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
}
