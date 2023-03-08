package com.nisum.service.expresions_configs.usecases.api;

import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;

import java.util.UUID;

public interface UpdateExpressionConfigUseCase {
    ExpressionConfigsCore execute(UUID configId, ExpressionConfigsCore expressionConfigsCore);
}
