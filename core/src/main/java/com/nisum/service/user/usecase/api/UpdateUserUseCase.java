package com.nisum.service.user.usecase.api;

import com.nisum.service.user.entities.UserCore;

import java.util.UUID;

public interface UpdateUserUseCase {
    UserCore execute(UUID userId, UserCore userCore);
}
