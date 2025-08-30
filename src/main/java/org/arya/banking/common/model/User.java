package org.arya.banking.common.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.arya.banking.common.metadata.annotation.TrackMetadata;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@Document(collection = "user")
@TrackMetadata(name = "User", description = "Stores information about the User")
public class User extends AryaBase {

    @Id
    private String id;

    @NotNull
    @Field("userId")
    @Indexed(unique = true)
    private String userId;

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
    @Field("contactNumbers")
    private List<ContactNumber> contactNumbers;

    @NotNull
    @Field("primaryContactNumber")
    private String primaryContactNumber;

    @NotNull
    @Field("addresses")
    private List<Address> addresss;

    @NotNull
    @Field("primaryAddress")
    private Address primaryAddress;

    @NotNull
    @Field("status")
    private String status;

    @NotNull
    @Field("roleId")
    private String roleId;

    @NotNull
    @Field("securityDetailId")
    private String securityDetailId;
}
