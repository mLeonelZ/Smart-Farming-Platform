package br.com.agricoladigital.smart_farming_api.dto.response;

public record FazendaResponse(
        Long id,
        String nome,
        String localizacao,
        Double areaTotal,
        Long usuarioId
) {
}
