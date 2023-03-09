package com.nisum.service.user.usecase.impl;


import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.shared.enums.ExpressionConfigEnum;
import com.nisum.service.user.entities.UserCore;
import com.nisum.service.user.exception.UserException;
import com.nisum.service.user.ports.UserDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseImplTest {

    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCase;

    @Mock
    private UserDomain userDomain;

    @Mock
    private GetPatternByNameUseCase getPatternByNameUseCase;

    @Test
    void shouldCreateUser() {
        when(getPatternByNameUseCase.execute(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION)).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(getPatternByNameUseCase.execute(ExpressionConfigEnum.PASSWORD_REGULAR_EXPRESSION)).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        when(userDomain.getUserByEmail(any())).thenReturn(Optional.empty());
        UserCore userCore = new UserCore();
        userCore.setName("Sebas");
        userCore.setEmail("sebastiantravez@gmail.com");
        userCore.setPassword("Testpriebas123.");
        userCore.setToken("3423423432423");
        userCore.setLastLogin(LocalDateTime.now());
        userCore.setModified(LocalDateTime.now());
        createUserUseCase.execute(userCore);
        verify(userDomain).getUserByEmail(any());
    }

    @Test
    void shouldCreateUserExceptionEmailInvalid() {
        when(getPatternByNameUseCase.execute(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION)).thenReturn("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$");
        when(getPatternByNameUseCase.execute(ExpressionConfigEnum.PASSWORD_REGULAR_EXPRESSION)).thenReturn("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
        when(userDomain.getUserByEmail(any())).thenReturn(Optional.empty());
        UserCore userCore = new UserCore();
        userCore.setName("Sebas");
        userCore.setEmail("sebastiantravez@");
        userCore.setPassword("Testpriebas123.");
        userCore.setToken("3423423432423");
        userCore.setLastLogin(LocalDateTime.now());
        userCore.setModified(LocalDateTime.now());
        UserException exception = assertThrows(UserException.class, () -> {
            createUserUseCase.execute(userCore);
        });
        assertEquals(exception.getMessage(), "Error: El email no cumple el formato establecido");
        verify(userDomain).getUserByEmail(any());
    }

}