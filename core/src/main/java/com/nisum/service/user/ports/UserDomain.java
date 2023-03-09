package com.nisum.service.user.ports;

import com.nisum.service.user.entities.UserCore;

import java.util.Optional;
import java.util.UUID;

public interface UserDomain {
    UserCore save(UserCore userCore);

    Optional<UserCore> getUserById(UUID userId);

    Optional<UserCore> getUserByEmail(String email);

    UserCore update(UUID userId, UserCore userCore);

    void deleteUserById(UUID userId);
}
