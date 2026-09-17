package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "previsao_tempo")
@Getter
@NoArgsConstructor
public class PrevisaoTempo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_previsao")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fazenda", nullable = false)
    private Fazenda fazenda;

    @Column(name = "data_previsao", nullable = false)
    private LocalDate dataPrevisao;

    @Column(name = "temperatura_prevista")
    private Double temperaturaPrevista;

    @Column(name = "precipitacao_prevista")
    private Double precipitacaoPrevista;

    @Column(name = "fonte_api", length = 100)
    private String fonteApi;

    public PrevisaoTempo(Fazenda fazenda, LocalDate dataPrevisao, Double temperaturaPrevista, Double precipitacaoPrevista, String fonteApi) {
        this.fazenda = fazenda;
        this.dataPrevisao = dataPrevisao;
        this.temperaturaPrevista = temperaturaPrevista;
        this.precipitacaoPrevista = precipitacaoPrevista;
        this.fonteApi = fonteApi;
    }
}