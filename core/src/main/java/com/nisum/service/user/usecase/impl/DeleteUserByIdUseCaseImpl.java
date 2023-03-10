package com.nisum.service.user.usecase.impl;

import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.persistence.UserCoreRepository;
import com.nisum.service.user.usecase.api.DeleteUserByIdUseCase;

import java.util.UUID;

public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {

    private final UserCoreRepository userCoreRepository;

    public DeleteUserByIdUseCaseImpl(UserCoreRepository userCoreRepository) {
        this.userCoreRepository = userCoreRepository;
    }

    @Override
    public void execute(UUID userId) {
        userCoreRepository.getUserById(userId).orElseThrow(() -> new UserException("Error: El usuario no existe no se puede eliminar"));
        userCoreRepository.deleteUserById(userId);
    }
}
