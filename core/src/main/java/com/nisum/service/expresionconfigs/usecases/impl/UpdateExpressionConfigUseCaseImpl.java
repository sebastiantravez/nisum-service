package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.exception.ExpressionConfigException;
import com.nisum.service.expresionconfigs.ports.persistence.ExpressionConfigCoreRepository;
import com.nisum.service.expresionconfigs.usecases.api.UpdateExpressionConfigUseCase;

import java.util.UUID;

public class UpdateExpressionConfigUseCaseImpl implements UpdateExpressionConfigUseCase {

    private final ExpressionConfigCoreRepository expressionConfigCoreRepository;

    public UpdateExpressionConfigUseCaseImpl(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        this.expressionConfigCoreRepository = expressionConfigCoreRepository;
    }

    @Override
    public ExpressionConfigsCore execute(UUID configId, ExpressionConfigsCore expressionConfigsCore) {
        ExpressionConfigsCore configsCore = expressionConfigCoreRepository.getExpressionConfigById(configId)
                .orElseThrow(() -> new ExpressionConfigException("Error: Registro no existe"));
        configsCore.setName(expressionConfigsCore.getName());
        configsCore.setDescription(expressionConfigsCore.getDescription());
        configsCore.setPattern(expressionConfigsCore.getPattern());
        return expressionConfigCoreRepository.update(configsCore);
    }

}
