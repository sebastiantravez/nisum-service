package com.nisum.service.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PhoneDto {
    private UUID id;
    @NotNull
    private String number;
    @NotNull
    @JsonProperty("citycode")
    private String cityCode;
    @NotNull
    @JsonProperty("contrycode")
    private String countryCode;
}
