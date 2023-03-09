package com.nisum.service.app.configuration;

import com.nisum.service.app.utils.GlobalMapper;
import com.nisum.service.expresionconfigs.ports.ExpressionConfigsDomain;
import com.nisum.service.expresionconfigs.usecases.api.CreateExpressionConfigUseCase;
import com.nisum.service.expresionconfigs.usecases.api.GetAllExpressionUseCase;
import com.nisum.service.expresionconfigs.usecases.api.GetPatternByNameUseCase;
import com.nisum.service.expresionconfigs.usecases.api.UpdateExpressionConfigUseCase;
import com.nisum.service.expresionconfigs.usecases.impl.CreateExpressionConfigUseCaseImpl;
import com.nisum.service.expresionconfigs.usecases.impl.GetAllExpressionUseCaseImpl;
import com.nisum.service.expresionconfigs.usecases.impl.GetPatternByNameUseCaseImpl;
import com.nisum.service.expresionconfigs.usecases.impl.UpdateExpressionConfigUseCaseImpl;
import com.nisum.service.user.ports.UserDomain;
import com.nisum.service.user.usecase.api.CreateUserUseCase;
import com.nisum.service.user.usecase.api.GetUserByIdUseCase;
import com.nisum.service.user.usecase.impl.CreateUserUseCaseImpl;
import com.nisum.service.user.usecase.impl.GetUserByIdUseCaseImpl;
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
    public CreateExpressionConfigUseCase createExpressionConfigUseCase(ExpressionConfigsDomain expressionConfigsDomain) {
        return new CreateExpressionConfigUseCaseImpl(expressionConfigsDomain);
    }

    @Bean
    public GetAllExpressionUseCase getAllExpressionUseCase(ExpressionConfigsDomain expressionConfigsDomain) {
        return new GetAllExpressionUseCaseImpl(expressionConfigsDomain);
    }

    @Bean
    public UpdateExpressionConfigUseCase updateExpressionConfigUseCase(ExpressionConfigsDomain expressionConfigsDomain) {
        return new UpdateExpressionConfigUseCaseImpl(expressionConfigsDomain);
    }

    @Bean
    public GetPatternByNameUseCase getPatternByNameUseCase(ExpressionConfigsDomain expressionConfigsDomain) {
        return new GetPatternByNameUseCaseImpl(expressionConfigsDomain);
    }

    @Bean
    public CreateUserUseCase createUserUseCase(UserDomain userDomain, GetPatternByNameUseCase getPatternByNameUseCase) {
        return new CreateUserUseCaseImpl(userDomain, getPatternByNameUseCase);
    }

    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserDomain userDomain) {
        return new GetUserByIdUseCaseImpl(userDomain);
    }
}
