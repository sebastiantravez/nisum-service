package com.nisum.service.app.dto;

import com.nisum.service.shared.enums.ExpressionConfigEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpressionConfigDto {
    private UUID id;
    @NotNull
    private ExpressionConfigEnum name;
    @NotNull
    private String description;
    @NotNull
    private String pattern;
}

