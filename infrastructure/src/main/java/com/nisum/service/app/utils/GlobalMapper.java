package com.nisum.service.app.utils;

import com.nisum.service.app.dto.ExpressionConfigDto;
import com.nisum.service.app.dto.UserDto;
import com.nisum.service.expresions_configs.entities.ExpressionConfigsCore;
import com.nisum.service.user.entities.UserCore;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GlobalMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ExpressionConfigsCore expressionConfigDtoToCoreEntity(ExpressionConfigDto expressionConfigDto) {
        return modelMapper.map(expressionConfigDto, ExpressionConfigsCore.class);
    }

    public ExpressionConfigDto expressionConfigCoreFromCoreEntity(ExpressionConfigsCore expressionConfigsCore) {
        return modelMapper.map(expressionConfigsCore, ExpressionConfigDto.class);
    }

    public List<ExpressionConfigDto> expressionConfigCoreFromCoreEntities(List<ExpressionConfigsCore> expressionConfigsCore) {
        return expressionConfigsCore.stream().map(data -> modelMapper.map(data, ExpressionConfigDto.class)).toList();
    }

    public UserCore userCoreDtoToCoreEntity(UserDto userDto) {
        return modelMapper.map(userDto, UserCore.class);
    }

    public UserDto userCoreFromCoreEntity(UserCore userCore) {
        return modelMapper.map(userCore, UserDto.class);
    }
}
