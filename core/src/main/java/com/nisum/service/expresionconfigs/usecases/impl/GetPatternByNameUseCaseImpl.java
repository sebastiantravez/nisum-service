package com.nisum.service.expresionconfigs.usecases.impl;

import com.nisum.service.expresionconfigs.exception.ExpressionConfigException;
import com.nisum.service.expresionconfigs.ports.persistence.ExpressionConfigCoreRepository;
import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.shared.enums.ExpressionConfigEnum;

import java.util.Optional;

public class GetPatternByNameUseCaseImpl implements GetPatternByNameUseCase {

    private final ExpressionConfigCoreRepository expressionConfigCoreRepository;

    public GetPatternByNameUseCaseImpl(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        this.expressionConfigCoreRepository = expressionConfigCoreRepository;
    }

    @Override
    public String execute(ExpressionConfigEnum name) {
        Optional<String> getPattern = expressionConfigCoreRepository.getPatternByName(name);
        if (getPattern.isEmpty()) {
            throw new ExpressionConfigException(String.format("Error: debe configurar el patron: %s", name));
        }
        return getPattern.get();
    }
}
