package com.nisum.service.expresions_configs.usecases.impl;

import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;
import com.nisum.service.expresions_configs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresions_configs.usecases.api.GetAllExpressionUseCase;

import java.util.List;

public class GetAllExpressionUseCaseImpl implements GetAllExpressionUseCase {

    private final ExpressionConfigsDomain expressionConfigsDomain;

    public GetAllExpressionUseCaseImpl(ExpressionConfigsDomain expressionConfigsDomain) {
        this.expressionConfigsDomain = expressionConfigsDomain;
    }

    @Override
    public List<ExpressionConfigsCore> execute() {
        return expressionConfigsDomain.getAll();
    }
}
