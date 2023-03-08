package com.nisum.service.expresions_configs.usecases.api;

import com.nisum.service.shared.enums.ExpressionConfigEnum;


public interface GetPatternByNameUseCase {
    String execute(ExpressionConfigEnum name);
}
