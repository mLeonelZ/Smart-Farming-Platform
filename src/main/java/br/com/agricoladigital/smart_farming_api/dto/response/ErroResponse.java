package br.com.agricoladigital.smart_farming_api.dto.response;

import java.time.LocalDateTime;
import java.util.Map;

public record ErroResponse(
        LocalDateTime dataHora,
        int status,
        String erro,
        String mensagem,
        Map<String, String> detalhes
) {
}
