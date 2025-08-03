package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@TrackMetadata(name = "Contact Number", description = "Stores information of contact numbers related to Users")
public class ContactNumber {

    @NotNull
    @Field("userId")
    private String userId;

    @NotNull
    @Field("contactNumber")
    @Pattern(regexp = "^[6-9][0-9]{9}$")
    private String contactNumber;

    @NotNull
    @Field("type")
    private ContactNumberType type;

    @NotNull
    @Field("isVerified")
    private boolean isVerified;
}
