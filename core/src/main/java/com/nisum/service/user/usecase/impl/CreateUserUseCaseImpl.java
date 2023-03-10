package com.nisum.service.user.usecase.impl;

import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.persistence.UserCoreRepository;
import com.nisum.service.user.usecase.api.CreateUserUseCase;
import com.nisum.service.utils.ValidateUser;

import java.util.Optional;

public class CreateUserUseCaseImpl extends ValidateUser implements CreateUserUseCase {

    private final UserCoreRepository userCoreRepository;

    public CreateUserUseCaseImpl(UserCoreRepository userCoreRepository, GetPatternByNameUseCase getPatternByNameUseCase) {
        super(getPatternByNameUseCase);
        this.userCoreRepository = userCoreRepository;
    }

    @Override
    public UserCore execute(UserCore userCore) {
        Optional<UserCore> userCoreOptional = userCoreRepository.getUserByEmail(userCore.getEmail());

        if (userCoreOptional.isPresent()) throw new UserException("Error: El email ya se encuentra registrado");

        validateUserData(userCore);

        return userCoreRepository.save(userCore);
    }
}
