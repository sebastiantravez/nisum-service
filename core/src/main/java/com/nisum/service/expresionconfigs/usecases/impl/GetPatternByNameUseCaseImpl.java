package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.exception.ExpressionConfigException;
import com.nisum.service.expresionconfigs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
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
