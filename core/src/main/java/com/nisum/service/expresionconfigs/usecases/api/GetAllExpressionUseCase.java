package com.nisum.service.expresionconfigs.usecases.api;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;

import java.util.List;

public interface GetAllExpressionUseCase {
    List<ExpressionConfigsCore> execute();
}
