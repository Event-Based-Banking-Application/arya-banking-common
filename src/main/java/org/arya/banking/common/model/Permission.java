package org.arya.banking.common.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

import java.util.List;

@Data
public class Permission {

    @Field("module")
    private String module;

    @Field("actions")
    private List<String> actions;
}
