package com.nisum.service.user.usecase.api;

import com.nisum.service.user.entities.UserCore;

import java.util.UUID;

public interface GetUserByIdUseCase {
    UserCore execute(UUID userId);
}
