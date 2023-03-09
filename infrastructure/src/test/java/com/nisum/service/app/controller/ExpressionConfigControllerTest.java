package com.nisum.service.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nisum.service.app.dto.ExpressionConfigDto;
import com.nisum.service.app.utils.GlobalMapper;
import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.usecases.api.CreateExpressionConfigUseCase;
import com.nisum.service.expresionconfigs.usecases.api.GetAllExpressionUseCase;
import com.nisum.service.shared.enums.ExpressionConfigEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ExpressionConfigControllerTest {

    @InjectMocks
    private ExpressionConfigController expressionConfigController;

    @Mock
    private CreateExpressionConfigUseCase createExpressionConfigUseCase;

    @Mock
    private GetAllExpressionUseCase getAllExpressionUseCase;

    @Mock
    private GlobalMapper globalMapper;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private ExpressionConfigsCore expressionConfigsCore;

    private ExpressionConfigDto expressionConfigDto;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(expressionConfigController).build();
        objectMapper = new ObjectMapper();
        expressionConfigsCore = new ExpressionConfigsCore();
        expressionConfigsCore.setName(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION);
        expressionConfigsCore.setPattern("EMAIL_REGULAR_EXPRESSION");
        expressionConfigsCore.setDescription("Email pattern");

        expressionConfigDto = new ExpressionConfigDto();
        expressionConfigDto.setName(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION);
        expressionConfigDto.setPattern("EMAIL_REGULAR_EXPRESSION");
        expressionConfigDto.setDescription("Email Pattern");
    }

    @Test
    void shouldCreateUser() throws Exception {
        mockMvc.perform(post("/createExpression")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(expressionConfigDto)))
                .andExpect(status().isOk());

        when(globalMapper.expressionConfigDtoToCoreEntity(any())).thenReturn(expressionConfigsCore);
        when(globalMapper.expressionConfigCoreFromCoreEntity(any())).thenReturn(expressionConfigDto);
        when(createExpressionConfigUseCase.execute(any())).thenReturn(expressionConfigsCore);
        expressionConfigController.createExpression(expressionConfigDto);
        verify(createExpressionConfigUseCase, times(2)).execute(any());
    }

    @Test
    void shouldCreateUserExceptionNotFound() throws Exception {
        mockMvc.perform(post("/createExpressiones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ExpressionConfigDto.builder()
                                .pattern("EMAIL_REGULAR_EXPRESSION")
                                .name(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION)
                                .description("Email pattern")
                                .build())))
                .andExpect(status().isNotFound());
        when(createExpressionConfigUseCase.execute(any())).thenReturn(any());
        expressionConfigController.createExpression(ExpressionConfigDto.builder()
                .name(ExpressionConfigEnum.EMAIL_REGULAR_EXPRESSION)
                .pattern("EMAIL_REGULAR_EXPRESSION")
                .description("Email pattern")
                .build());
        verify(createExpressionConfigUseCase).execute(any());
    }

    @Test
    void getAllExpressions() throws Exception {
        mockMvc.perform(get("/getAllExpressions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        expressionConfigController.getAllExpressions();
        verify(getAllExpressionUseCase, times(2)).execute();
    }

}