package com.nisum.service.user.usecase.impl;

import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.UserDomain;
import com.nisum.service.user.usecase.api.CreateUserUseCase;
import com.nisum.service.utils.ValidateUser;

import java.util.Optional;

public class CreateUserUseCaseImpl extends ValidateUser implements CreateUserUseCase {

    private final UserDomain userDomain;

    public CreateUserUseCaseImpl(UserDomain userDomain, GetPatternByNameUseCase getPatternByNameUseCase) {
        super(getPatternByNameUseCase);
        this.userDomain = userDomain;
    }

    @Override
    public UserCore execute(UserCore userCore) {
        Optional<UserCore> userCoreOptional = userDomain.getUserByEmail(userCore.getEmail());

        if (userCoreOptional.isPresent()) throw new UserException("Error: El email ya se encuentra registrado");

        validateUserData(userCore);

        return userDomain.save(userCore);
    }
}
