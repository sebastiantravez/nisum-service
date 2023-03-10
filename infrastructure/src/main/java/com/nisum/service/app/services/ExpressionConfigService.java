package com.nisum.service.app.services;

import com.nisum.service.app.entities.ExpressionConfigs;
import com.nisum.service.app.repository.ExpressionConfigRepository;
import com.nisum.service.expresionconfigs.entities.ExpressionConfigsCore;
import com.nisum.service.expresionconfigs.ports.persistence.ExpressionConfigCoreRepository;
import com.nisum.service.shared.enums.ExpressionConfigEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpressionConfigService implements ExpressionConfigCoreRepository {

    @Autowired
    private ExpressionConfigRepository expressionConfigRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ExpressionConfigsCore save(ExpressionConfigsCore expressionConfigsCore) {
        ExpressionConfigs expressionConfigs = expressionConfigRepository.save(modelMapper.map(expressionConfigsCore, ExpressionConfigs.class));
        return modelMapper.map(expressionConfigs, ExpressionConfigsCore.class);
    }

    @Override
    public List<ExpressionConfigsCore> getAll() {
        List<ExpressionConfigs> expressionConfigsList = expressionConfigRepository.findAll();
        return expressionConfigsList.stream().map(data -> modelMapper.map(data, ExpressionConfigsCore.class)).toList();
    }

    @Override
    public ExpressionConfigsCore update(ExpressionConfigsCore expressionConfigsCore) {
        ExpressionConfigs expressionConfigs = expressionConfigRepository.save(modelMapper.map(expressionConfigsCore, ExpressionConfigs.class));
        return modelMapper.map(expressionConfigs, ExpressionConfigsCore.class);
    }

    @Override
    public Optional<ExpressionConfigsCore> getExpressionConfigByName(ExpressionConfigEnum name) {
        ExpressionConfigs expressionConfigs = expressionConfigRepository.findByName(name).orElse(null);
        return expressionConfigs != null ? Optional.of(modelMapper.map(expressionConfigs, ExpressionConfigsCore.class)) : Optional.empty();
    }

    @Override
    public Optional<ExpressionConfigsCore> getExpressionConfigById(UUID id) {
        ExpressionConfigs expressionConfigs = expressionConfigRepository.findById(id).orElse(null);
        return expressionConfigs != null ? Optional.of(modelMapper.map(expressionConfigs, ExpressionConfigsCore.class)) : Optional.empty();
    }

    @Override
    public Optional<String> getPatternByName(ExpressionConfigEnum name) {
        ExpressionConfigs expressionConfigs = expressionConfigRepository.findByName(name).orElse(null);
        return expressionConfigs != null ? Optional.of(expressionConfigs.getPattern()) : Optional.empty();
    }
}
