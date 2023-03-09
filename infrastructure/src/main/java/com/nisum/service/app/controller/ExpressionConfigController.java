package com.nisum.service.app.controller;

import com.nisum.service.app.dto.ExpressionConfigDto;
import com.nisum.service.app.utils.GlobalMapper;
import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.usecases.api.CreateExpressionConfigUseCase;
import com.nisum.service.expresionconfigs.usecases.api.GetAllExpressionUseCase;
import com.nisum.service.expresionconfigs.usecases.api.UpdateExpressionConfigUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ExpressionConfigController {

    @Autowired
    private CreateExpressionConfigUseCase createExpressionConfigUseCase;

    @Autowired
    private GetAllExpressionUseCase getAllExpressionUseCase;

    @Autowired
    private UpdateExpressionConfigUseCase updateExpressionConfigUseCase;

    @Autowired
    private GlobalMapper globalMapper;

    @PostMapping("/createExpression")
    public ExpressionConfigDto createExpression(@Valid @RequestBody ExpressionConfigDto expressionConfigDto) {
        ExpressionConfigsCore expressionConfigsCore = createExpressionConfigUseCase.execute(globalMapper.expressionConfigDtoToCoreEntity(expressionConfigDto));
        return globalMapper.expressionConfigCoreFromCoreEntity(expressionConfigsCore);
    }

    @GetMapping("/getAllExpressions")
    public List<ExpressionConfigDto> getAllExpressions() {
        return globalMapper.expressionConfigCoreFromCoreEntities(getAllExpressionUseCase.execute());
    }

    @PutMapping("/updateExpressionConfig/{expressionId}")
    public ExpressionConfigDto updateExpressionConfig(@Valid @PathVariable("expressionId") UUID expressionId, @RequestBody ExpressionConfigDto expressionConfigDto) {
        ExpressionConfigsCore expressionConfigsCore = updateExpressionConfigUseCase.execute(expressionId, globalMapper.expressionConfigDtoToCoreEntity(expressionConfigDto));
        return globalMapper.expressionConfigCoreFromCoreEntity(expressionConfigsCore);
    }

}
