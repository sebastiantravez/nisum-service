package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.exception.ExpressionConfigException;
import com.nisum.service.expresionconfigs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresionconfigs.usecases.api.UpdateExpressionConfigUseCase;

import java.util.UUID;

public class UpdateExpressionConfigUseCaseImpl implements UpdateExpressionConfigUseCase {

    private final ExpressionConfigsDomain expressionConfigsDomain;

    public UpdateExpressionConfigUseCaseImpl(ExpressionConfigsDomain expressionConfigsDomain) {
        this.expressionConfigsDomain = expressionConfigsDomain;
    }

    @Override
    public ExpressionConfigsCore execute(UUID configId, ExpressionConfigsCore expressionConfigsCore) {
        ExpressionConfigsCore configsCore = expressionConfigsDomain.getExpressionConfigById(configId)
                .orElseThrow(() -> new ExpressionConfigException("Error: Registro no existe"));
        configsCore.setName(expressionConfigsCore.getName());
        configsCore.setDescription(expressionConfigsCore.getDescription());
        configsCore.setPattern(expressionConfigsCore.getPattern());
        return expressionConfigsDomain.update(configsCore);
    }

}
