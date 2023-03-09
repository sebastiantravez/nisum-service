package com.nisum.service.user.usecase.impl;

import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.UserDomain;
import com.nisum.service.user.usecase.api.GetUserByIdUseCase;

import java.util.UUID;

public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

    private final UserDomain userDomain;

    public GetUserByIdUseCaseImpl(UserDomain userDomain) {
        this.userDomain = userDomain;
    }

    @Override
    public UserCore execute(UUID userId) {
        return userDomain.getUserById(userId).orElseThrow(() -> new UserException("Error: El usuario no existe"));
    }
}
