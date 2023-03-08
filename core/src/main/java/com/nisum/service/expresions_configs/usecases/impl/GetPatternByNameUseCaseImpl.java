package com.nisum.service.expresions_configs.usecases.impl;

import com.nisum.service.expresions_configs.exception.ExpressionConfigException;
import com.nisum.service.expresions_configs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresions_configs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.shared.enums.ExpressionConfigEnum;

import java.util.Optional;

public class GetPatternByNameUseCaseImpl implements GetPatternByNameUseCase {

    private final ExpressionConfigsDomain expressionConfigsDomain;

    public GetPatternByNameUseCaseImpl(ExpressionConfigsDomain expressionConfigsDomain) {
        this.expressionConfigsDomain = expressionConfigsDomain;
    }

    @Override
    public String execute(ExpressionConfigEnum name) {
        Optional<String> getPattern = expressionConfigsDomain.getPatternByName(name);
        if (getPattern.isEmpty()) {
            throw new ExpressionConfigException(String.format("Error: debe configurar el patron: %s", name));
        }
        return getPattern.get();
    }
}
