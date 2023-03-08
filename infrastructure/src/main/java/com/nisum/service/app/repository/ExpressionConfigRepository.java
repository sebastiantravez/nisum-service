package com.nisum.service.app.repository;

import com.nisum.service.app.entities.ExpressionConfigs;
import com.nisum.service.shared.enums.ExpressionConfigEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExpressionConfigRepository extends JpaRepository<ExpressionConfigs, UUID> {
    Optional<ExpressionConfigs> findByName(ExpressionConfigEnum name);
}
