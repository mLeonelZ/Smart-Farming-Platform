package br.com.agricoladigital.smart_farming_api.dto.response;

public record TalhaoResponse(
        Long id,
        String identificacao,
        Double areaHectares,
        String geometria,
        Long fazendaId
) {
}
