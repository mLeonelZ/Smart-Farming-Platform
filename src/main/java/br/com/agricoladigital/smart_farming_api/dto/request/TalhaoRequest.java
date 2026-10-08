package br.com.agricoladigital.smart_farming_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TalhaoRequest(
        @NotBlank @Size(max = 100) String identificacao,
        @NotNull @Positive Double areaHectares,
        @Size(max = 255) String geometria
) {
}
