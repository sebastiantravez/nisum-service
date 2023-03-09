package com.nisum.service.expresionconfigs.entities;

import com.nisum.service.shared.enums.ExpressionConfigEnum;

import java.util.UUID;

public class ExpressionConfigsCore {
    private UUID id;
    private ExpressionConfigEnum name;
    private String description;
    private String pattern;

    public ExpressionConfigsCore() {
    }

    public ExpressionConfigsCore(UUID id, ExpressionConfigEnum name, String description, String pattern) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.pattern = pattern;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ExpressionConfigEnum getName() {
        return name;
    }

    public void setName(ExpressionConfigEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
