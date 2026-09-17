package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regra_alerta")
@Getter
@NoArgsConstructor
public class RegraAlerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_regra")
    private Long id;

    @Column(name = "tipo_evento", nullable = false, length = 100)
    private String tipoEvento;

    @Column(name = "condicao_limite", nullable = false)
    private Double condicaoLimite;

    @Column(length = 255)
    private String descricao;

    public RegraAlerta(
            String tipoEvento,
            Double condicaoLimite,
            String descricao
    ) {
        this.tipoEvento = tipoEvento;
        this.condicaoLimite = condicaoLimite;
        this.descricao = descricao;
    }
}