package com.nisum.service.expresions_configs.usecases.api;

import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;

public interface CreateExpressionConfigUseCase {
    ExpressionConfigsCore execute(ExpressionConfigsCore expressionConfigsCore);
}
