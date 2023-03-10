package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.exception.ExpressionConfigException;
import com.nisum.service.expresionconfigs.ports.persistence.ExpressionConfigCoreRepository;
import com.nisum.service.expresionconfigs.usecases.api.CreateExpressionConfigUseCase;

import java.util.Optional;

public class CreateExpressionConfigUseCaseImpl implements CreateExpressionConfigUseCase {

    private final ExpressionConfigCoreRepository expressionConfigCoreRepository;

    public CreateExpressionConfigUseCaseImpl(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        this.expressionConfigCoreRepository = expressionConfigCoreRepository;
    }

    @Override
    public ExpressionConfigsCore execute(ExpressionConfigsCore expressionConfigsCore) {
        Optional<ExpressionConfigsCore> expressionConfig = expressionConfigCoreRepository.getExpressionConfigByName(expressionConfigsCore.getName());
        if (expressionConfig.isPresent()) {
            throw new ExpressionConfigException("Error: Ya existe una configuracion con el mismo nombre");
        }
        return expressionConfigCoreRepository.save(expressionConfigsCore);
    }
}
