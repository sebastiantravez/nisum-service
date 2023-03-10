package com.nisum.service.user.ports.persistence;

import com.nisum.service.user.entities.UserCore;

import java.util.Optional;
import java.util.UUID;

public interface UserCoreRepository {
    UserCore save(UserCore userCore);

    Optional<UserCore> getUserById(UUID userId);

    Optional<UserCore> getUserByEmail(String email);

    UserCore update(UUID userId, UserCore userCore);

    void deleteUserById(UUID userId);
}
