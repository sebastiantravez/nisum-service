package com.nisum.service.expresionconfigs.usecases.api;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;

public interface CreateExpressionConfigUseCase {
    ExpressionConfigsCore execute(ExpressionConfigsCore expressionConfigsCore);
}
