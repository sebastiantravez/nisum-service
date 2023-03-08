package com.nisum.service.app.entities;

import com.nisum.service.shared.enums.ExpressionConfigEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "expression_configs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpressionConfigs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private ExpressionConfigEnum name;
    @NotNull
    private String description;
    @NotNull
    private String pattern;
}
