package com.nisum.service.user.usecase.impl;

import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.persistence.UserCoreRepository;
import com.nisum.service.user.usecase.api.GetUserByIdUseCase;

import java.util.UUID;

public class GetUserByIdUseCaseImpl implements GetUserByIdUseCase {

    private final UserCoreRepository userCoreRepository;

    public GetUserByIdUseCaseImpl(UserCoreRepository userCoreRepository) {
        this.userCoreRepository = userCoreRepository;
    }

    @Override
    public UserCore execute(UUID userId) {
        return userCoreRepository.getUserById(userId).orElseThrow(() -> new UserException("Error: El usuario no existe"));
    }
}
