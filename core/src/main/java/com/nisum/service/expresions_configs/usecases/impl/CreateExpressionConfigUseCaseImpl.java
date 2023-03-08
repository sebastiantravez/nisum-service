package com.nisum.service.expresions_configs.usecases.impl;

import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;
import com.nisum.service.expresions_configs.exception.ExpressionConfigException;
import com.nisum.service.expresions_configs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresions_configs.usecases.api.CreateExpressionConfigUseCase;

import java.util.Optional;

public class CreateExpressionConfigUseCaseImpl implements CreateExpressionConfigUseCase {

    private final ExpressionConfigsDomain expressionConfigsDomain;

    public CreateExpressionConfigUseCaseImpl(ExpressionConfigsDomain expressionConfigsDomain) {
        this.expressionConfigsDomain = expressionConfigsDomain;
    }

    @Override
    public ExpressionConfigsCore execute(ExpressionConfigsCore expressionConfigsCore) {
        Optional<ExpressionConfigsCore> expressionConfig = expressionConfigsDomain.getExpressionConfigByName(expressionConfigsCore.getName());
        if (expressionConfig.isPresent()) {
            throw new ExpressionConfigException("Error: Ya existe una configuracion con el mismo nombre");
        }
        return expressionConfigsDomain.save(expressionConfigsCore);
    }
}
