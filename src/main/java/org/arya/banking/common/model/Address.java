package org.arya.banking.common.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Schema(description = "User address information")
@TrackMetadata(name = "Address", description = "Stores the addresses of the users")
public class Address {

    @NotNull
    @Field("street")
    @Schema(description = "Street address", example = "123 Main Street")
    @Pattern(regexp = "^[a-zA-Z0-9\\s,.'-]{3,100}$", message = "Street name should have minimum 3 characters and maximum of 100 characters")
    private String street;

    @NotNull
    @Field("city")
    @Schema(description = "City", example = "New York")
    @Pattern(regexp = "^[a-zA-Z\\s.'-]{2,50}$", message = "Street name should have minimum 2 characters and maximum of 50 characters")
    private String city;

    @NotNull
    @Field("state")
    @Schema(description = "State or province", example = "NY")
    @Pattern(regexp = "^[a-zA-Z\\s.'-]{2,50}$", message = "Street name should have minimum 2 characters and maximum of 50 characters")
    private String state;

    @NotNull
    @Field("zipCode")
    @Schema(description = "ZIP or postal code", example = "10001")
    @Pattern(regexp = "^[a-zA-Z0-9\\s-]{3,15}$", message = "Street name should have minimum 3 characters and maximum of 15 characters")
    private String zipCode;

    @NotNull
    @Field("country")
    @Schema(description = "Country", example = "USA")
    @Pattern(regexp = "^[a-zA-Z\\s.'-]{2,56}$", message = "Street name should have minimum 2 characters and maximum of 56 characters")
    private String country;

    @NotNull
    @Field("isPrimary")
    @Schema(description = "Address type", example = "RESIDENTIAL")
    private AddressType addressType;
}
