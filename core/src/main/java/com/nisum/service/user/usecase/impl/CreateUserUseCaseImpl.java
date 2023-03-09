package com.nisum.service.user.usecase.impl;

import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.shared.enums.ExpressionConfigEnum;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.UserDomain;
import com.nisum.service.user.usecase.api.CreateUserUseCase;

import java.util.Optional;
import java.util.regex.Pattern;

public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final UserDomain userDomain;
    private final GetPatternByNameUseCase getPatternByNameUseCase;

    public CreateUserUseCaseImpl(UserDomain userDomain, GetPatternByNameUseCase getPatternByNameUseCase) {
        this.userDomain = userDomain;
        this.getPatternByNameUseCase = getPatternByNameUseCase;
    }

    @Override
    public UserCore execute(UserCore userCore) {
        Optional<UserCore> userCoreOptional = userDomain.getUserByEmail(userCore.getEmail());
        if (userCoreOptional.isPresent()) throw new UserException("Error: El email ya se encuentra registrado");
        validateUserData(userCore);
        return userDomain.save(userCore);
    }

    private void validateUserData(UserCore userCore) {
        if (isNullOrEmpty(userCore.getEmail())) {
            throw new UserException("Error: El usuario debe ingresar el email");
        }

        if (isNullOrEmpty(userCore.getEmail())) {
            throw new UserException("Error: El usuario debe ingresar el password");
        }

        Pattern emailPattern = Pattern.compile(getPatternEmailRegex());
        Pattern passwordPattern = Pattern.compile(getPatternPasswordRegex());

        if (!emailPattern.matcher(userCore.getEmail()).matches()) {
            throw new UserException("Error: El email no cumple el formato establecido");
        }

        if (!passwordPattern.matcher(userCore.getPassword()).matches()) {
            throw new UserException("La contraseña no cumple el formato establecido");
        }
    }

    public String getPatternEmailRegex() {
        return getPatternByNameUseCase.execute(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION);
    }

    public String getPatternPasswordRegex() {
        return getPatternByNameUseCase.execute(ExpressionConfigEnum.PASSWORD_REGULAR_EXPRESSION);
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isBlank() || str.isEmpty();
    }
}
