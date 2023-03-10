package com.nisum.service.app.services;

import com.nisum.service.app.entities.User;
import com.nisum.service.app.repository.UserRepository;
import com.nisum.service.app.utils.JwtToken;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.ports.persistence.UserCoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserCoreRepository {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserCore save(UserCore userCore) {
        User user = modelMapper.map(userCore, User.class);
        user.setToken(JwtToken.addToken(userCore));
        user.getPhones().forEach(phone -> phone.setUser(user));
        userRepository.save(user);
        return modelMapper.map(user, UserCore.class);
    }

    @Override
    public Optional<UserCore> getUserById(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? Optional.of(modelMapper.map(user, UserCore.class)) : Optional.empty();
    }

    @Override
    public Optional<UserCore> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null ? Optional.of(modelMapper.map(user, UserCore.class)) : Optional.empty();
    }

    @Override
    public UserCore update(UUID userId, UserCore userCore) {
        User user = userRepository.save(modelMapper.map(userCore, User.class));
        return modelMapper.map(user, UserCore.class);
    }

    @Override
    public void deleteUserById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
