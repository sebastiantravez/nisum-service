package com.nisum.service.user.utils;

import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.shared.enums.ExpressionConfigEnum;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;

import java.util.regex.Pattern;

public abstract class ValidateUser {

    private final GetPatternByNameUseCase getPatternByNameUseCase;

    protected ValidateUser(GetPatternByNameUseCase getPatternByNameUseCase) {
        this.getPatternByNameUseCase = getPatternByNameUseCase;
    }

    protected void validateUserData(UserCore userCore) {
        if (isNullOrEmpty(userCore.getEmail())) {
            throw new UserException("Error: El usuario debe ingresar el email");
        }
        if (isNullOrEmpty(userCore.getPassword())) {
            throw new UserException("Error: El usuario debe ingresar el password");
        }
        Pattern emailPattern = Pattern.compile(getPatternByNameUseCase.execute(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION));
        Pattern passwordPattern = Pattern.compile(getPatternByNameUseCase.execute(ExpressionConfigEnum.PASSWORD_REGULAR_EXPRESSION));
        if (!emailPattern.matcher(userCore.getEmail()).matches()) {
            throw new UserException("Error: El email no cumple el formato establecido");
        }
        if (!passwordPattern.matcher(userCore.getPassword()).matches()) {
            throw new UserException("La contraseña no cumple el formato establecido");
        }
    }

    protected boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

}
