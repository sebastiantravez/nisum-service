package com.nisum.service.expresionconfigs.usecases.api;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;

import java.util.UUID;

public interface UpdateExpressionConfigUseCase {
    ExpressionConfigsCore execute(UUID configId, ExpressionConfigsCore expressionConfigsCore);
}
