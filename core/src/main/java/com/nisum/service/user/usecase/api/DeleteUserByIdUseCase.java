package com.nisum.service.user.usecase.api;

import java.util.UUID;

public interface DeleteUserByIdUseCase {
    void execute(UUID userId);
}
