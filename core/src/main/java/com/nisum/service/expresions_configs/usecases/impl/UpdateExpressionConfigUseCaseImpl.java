package com.nisum.service.expresions_configs.usecases.impl;

import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;
import com.nisum.service.expresions_configs.exception.ExpressionConfigException;
import com.nisum.service.expresions_configs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresions_configs.usecases.api.UpdateExpressionConfigUseCase;

import java.util.UUID;

public class UpdateExpressionConfigUseCaseImpl implements UpdateExpressionConfigUseCase {

    private final ExpressionConfigsDomain expressionConfigsDomain;

    public UpdateExpressionConfigUseCaseImpl(ExpressionConfigsDomain expressionConfigsDomain) {
        this.expressionConfigsDomain = expressionConfigsDomain;
    }

    @Override
    public ExpressionConfigsCore execute(UUID configId, ExpressionConfigsCore expressionConfigsCore) {
        ExpressionConfigsCore configsCore = expressionConfigsDomain.getExpressionConfigById(configId)
                .orElseThrow(() -> new ExpressionConfigException("Registro no existe"));
        return expressionConfigsDomain.update(expressionConfigsCore);
    }

}
