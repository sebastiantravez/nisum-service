package com.nisum.service.user.usecase.impl;

import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.UserDomain;
import com.nisum.service.user.usecase.api.UpdateUserUseCase;
import com.nisum.service.utils.ValidateUser;

import java.util.Optional;
import java.util.UUID;

public class UpdateUserUseCaseImpl extends ValidateUser implements UpdateUserUseCase {

    private final UserDomain userDomain;

    public UpdateUserUseCaseImpl(UserDomain userDomain, GetPatternByNameUseCase getPatternByNameUseCase) {
        super(getPatternByNameUseCase);
        this.userDomain = userDomain;
    }

    @Override
    public UserCore execute(UUID userId, UserCore userCore) {
        Optional<UserCore> userCoreOptional = userDomain.getUserById(userId);

        if (userCoreOptional.isEmpty()) throw new UserException("Error: El usuario no existe, no se puede actualizar");

        userCoreOptional.get().setName(userCore.getName());
        userCoreOptional.get().setEmail(userCore.getEmail());
        userCoreOptional.get().setPassword(userCore.getPassword());
        userCoreOptional.get().getPhones().clear();
        userCoreOptional.get().setPhones(userCore.getPhones());
        validateUserData(userCoreOptional.get());

        Optional<UserCore> findUserEmail = userDomain.getUserByEmail(userCoreOptional.get().getEmail());
        if (findUserEmail.isPresent() && !findUserEmail.get().getId().equals(userId)) throw new UserException("Error: El email ya se encuentra registrado");

        return userDomain.save(userCoreOptional.get());
    }

}
