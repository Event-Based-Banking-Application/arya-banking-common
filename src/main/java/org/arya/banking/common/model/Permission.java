package org.arya.banking.common.model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class Permission {

    @Field("module")
    private String module;

    @Field("actions")
    private List<String> actions;

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
