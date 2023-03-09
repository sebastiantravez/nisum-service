package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresionconfigs.usecases.api.GetAllExpressionUseCase;

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
