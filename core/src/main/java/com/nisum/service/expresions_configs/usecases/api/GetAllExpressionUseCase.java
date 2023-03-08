package com.nisum.service.expresions_configs.usecases.api;

import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;

import java.util.List;

public interface GetAllExpressionUseCase {
    List<ExpressionConfigsCore> execute();
}
