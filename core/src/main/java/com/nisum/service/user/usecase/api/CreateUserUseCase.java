package com.nisum.service.user.usecase.api;

import com.nisum.service.user.entities.UserCore;

public interface CreateUserUseCase {
    UserCore execute(UserCore userCore);
}
