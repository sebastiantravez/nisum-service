package com.nisum.service.user.usecase.impl;

import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.UserDomain;
import com.nisum.service.user.usecase.api.DeleteUserByIdUseCase;

import java.util.UUID;

public class DeleteUserByIdUseCaseImpl implements DeleteUserByIdUseCase {

    private final UserDomain userDomain;

    public DeleteUserByIdUseCaseImpl(UserDomain userDomain) {
        this.userDomain = userDomain;
    }

    @Override
    public void execute(UUID userId) {
        userDomain.getUserById(userId).orElseThrow(() -> new UserException("Error: El usuario no existe no se puede eliminar"));
        userDomain.deleteUserById(userId);
    }
}
