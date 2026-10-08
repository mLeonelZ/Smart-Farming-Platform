package br.com.agricoladigital.smart_farming_api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record FazendaRequest(
        @NotBlank @Size(max = 150) String nome,
        @Size(max = 255) String localizacao,
        @NotNull @Positive Double areaTotal
) {
}
