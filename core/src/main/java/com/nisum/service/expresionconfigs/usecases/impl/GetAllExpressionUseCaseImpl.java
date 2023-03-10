package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.ports.persistence.ExpressionConfigCoreRepository;
import com.nisum.service.expresionconfigs.usecases.api.GetAllExpressionUseCase;

import java.util.List;

public class GetAllExpressionUseCaseImpl implements GetAllExpressionUseCase {

    private final ExpressionConfigCoreRepository expressionConfigCoreRepository;

    public GetAllExpressionUseCaseImpl(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        this.expressionConfigCoreRepository = expressionConfigCoreRepository;
    }

    @Override
    public List<ExpressionConfigsCore> execute() {
        return expressionConfigCoreRepository.getAll();
    }
}
