package com.nisum.service.expresionconfigs.ports.persistence;

import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.shared.enums.ExpressionConfigEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpressionConfigCoreRepository {
    ExpressionConfigsCore save(ExpressionConfigsCore expressionConfigsCore);

    List<ExpressionConfigsCore> getAll();

    ExpressionConfigsCore update(ExpressionConfigsCore expressionConfigsCore);

    Optional<ExpressionConfigsCore> getExpressionConfigByName(ExpressionConfigEnum name);

    Optional<ExpressionConfigsCore> getExpressionConfigById(UUID id);

    Optional<String> getPatternByName(ExpressionConfigEnum name);
}
