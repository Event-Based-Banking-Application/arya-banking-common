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
@Document(collection = "role")
@TrackMetadata(name = "Role", description = "Stores the information of the roles")
public class Role extends AryaBase {

    @Id
    private String id;

    @NotNull
    @Field("roleName")
    private String roleName;

    @NotNull
    @Field("description")
    private String description;

    @NotNull
    @Field("permissions")
    private List<Permission> permissions;
}
