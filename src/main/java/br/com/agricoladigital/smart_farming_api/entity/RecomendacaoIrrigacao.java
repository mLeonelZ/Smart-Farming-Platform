package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "recomendacao_irrigacao")
@Getter
@NoArgsConstructor
public class RecomendacaoIrrigacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recomendacao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_talhao", nullable = false)
    private Talhao talhao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_previsao")
    private PrevisaoTempo previsao;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "volume_recomendado_mm", nullable = false)
    private Double volumeRecomendadoMm;

    @Column(length = 500)
    private String justificativa;

    public RecomendacaoIrrigacao(
            Talhao talhao,
            PrevisaoTempo previsao,
            LocalDateTime dataHora,
            Double volumeRecomendadoMm,
            String justificativa
    ) {
        this.talhao = talhao;
        this.previsao = previsao;
        this.dataHora = dataHora;
        this.volumeRecomendadoMm = volumeRecomendadoMm;
        this.justificativa = justificativa;
    }
}