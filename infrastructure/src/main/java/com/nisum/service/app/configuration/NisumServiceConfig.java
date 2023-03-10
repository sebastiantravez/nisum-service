package com.nisum.service.app.configuration;

import com.nisum.service.app.utils.GlobalMapper;
import com.nisum.service.expresionconfigs.ports.persistence.ExpressionConfigCoreRepository;
import com.nisum.service.expresionconfigs.usecases.api.CreateExpressionConfigUseCase;
import com.nisum.service.expresionconfigs.usecases.api.GetAllExpressionUseCase;
import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.expresionconfigs.usecases.api.UpdateExpressionConfigUseCase;
import com.nisum.service.expresionconfigs.usecases.impl.CreateExpressionConfigUseCaseImpl;
import com.nisum.service.expresionconfigs.usecases.impl.GetAllExpressionUseCaseImpl;
import com.nisum.service.expresionconfigs.usecases.impl.GetPatternByNameUseCaseImpl;
import com.nisum.service.expresionconfigs.usecases.impl.UpdateExpressionConfigUseCaseImpl;
import com.nisum.service.user.ports.persistence.UserCoreRepository;
import com.nisum.service.user.usecase.api.CreateUserUseCase;
import com.nisum.service.user.usecase.api.DeleteUserByIdUseCase;
import com.nisum.service.user.usecase.api.GetUserByIdUseCase;
import com.nisum.service.user.usecase.api.UpdateUserUseCase;
import com.nisum.service.user.usecase.impl.CreateUserUseCaseImpl;
import com.nisum.service.user.usecase.impl.DeleteUserByIdUseCaseImpl;
import com.nisum.service.user.usecase.impl.GetUserByIdUseCaseImpl;
import com.nisum.service.user.usecase.impl.UpdateUserUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NisumServiceConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public GlobalMapper globalMapper() {
        GlobalMapper globalMapper = new GlobalMapper();
        return globalMapper;
    }

    @Bean
    public CreateExpressionConfigUseCase createExpressionConfigUseCase(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        return new CreateExpressionConfigUseCaseImpl(expressionConfigCoreRepository);
    }

    @Bean
    public GetAllExpressionUseCase getAllExpressionUseCase(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        return new GetAllExpressionUseCaseImpl(expressionConfigCoreRepository);
    }

    @Bean
    public UpdateExpressionConfigUseCase updateExpressionConfigUseCase(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        return new UpdateExpressionConfigUseCaseImpl(expressionConfigCoreRepository);
    }

    @Bean
    public GetPatternByNameUseCase getPatternByNameUseCase(ExpressionConfigCoreRepository expressionConfigCoreRepository) {
        return new GetPatternByNameUseCaseImpl(expressionConfigCoreRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserCoreRepository userCoreRepository, GetPatternByNameUseCase getPatternByNameUseCase) {
        return new CreateUserUseCaseImpl(userCoreRepository, getPatternByNameUseCase);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserCoreRepository userCoreRepository) {
        return new GetUserByIdUseCaseImpl(userCoreRepository);
    }

    @Bean
    public UpdateUserUseCase updateUserUseCase(UserCoreRepository userCoreRepository, GetPatternByNameUseCase getPatternByNameUseCase) {
        return new UpdateUserUseCaseImpl(userCoreRepository, getPatternByNameUseCase);
    }

    @Bean
    public DeleteUserByIdUseCase deleteUserByIdUseCase(UserCoreRepository userCoreRepository) {
        return new DeleteUserByIdUseCaseImpl(userCoreRepository);
    }
}
