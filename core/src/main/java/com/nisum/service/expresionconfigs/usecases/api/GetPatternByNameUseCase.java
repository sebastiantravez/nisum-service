package com.nisum.service.expresionconfigs.usecases.api;

import com.nisum.service.shared.enums.ExpressionConfigEnum;


public interface GetPatternByNameUseCase {
    String execute(ExpressionConfigEnum name);
}
