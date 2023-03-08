package com.nisum.service.app.controller;

import com.nisum.service.app.dto.UserDto;
import com.nisum.service.app.utils.GlobalMapper;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.usecase.api.CreateUserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GlobalMapper globalMapper;

    @PostMapping("/createUser")
    public UserDto createUser(@Valid @RequestBody UserDto userDto) {
        UserCore userCore = createUserUseCase.execute(globalMapper.userCoreDtoToCoreEntity(userDto));
        return globalMapper.userCoreFromCoreEntity(userCore);
    }


}
