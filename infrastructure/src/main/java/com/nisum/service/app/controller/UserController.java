package com.nisum.service.app.controller;

import com.nisum.service.app.dto.UserDto;
import com.nisum.service.app.utils.GlobalMapper;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.usecase.api.CreateUserUseCase;
import com.nisum.service.user.usecase.api.GetUserByIdUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetUserByIdUseCase getUserByIdUseCase;

    @Autowired
    private GlobalMapper globalMapper;

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable("userId") UUID userId) {
        UserCore userCore = getUserByIdUseCase.execute(userId);
        return globalMapper.userCoreFromCoreEntity(userCore);
    }

    @PostMapping("/createUser")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        UserCore userCore = createUserUseCase.execute(globalMapper.userCoreDtoToCoreEntity(userDto));
        return globalMapper.userCoreFromCoreEntity(userCore);
    }


}
