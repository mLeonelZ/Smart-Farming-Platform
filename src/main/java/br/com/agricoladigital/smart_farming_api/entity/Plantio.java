package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "plantio")
@Getter
@NoArgsConstructor
public class Plantio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plantio")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_talhao", nullable = false)
    private Talhao talhao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cultura", nullable = false)
    private Cultura cultura;

    @Column(name = "data_plantio", nullable = false)
    private LocalDate dataPlantio;

    @Column(name = "data_colheita_prevista")
    private LocalDate dataColheitaPrevista;

    @Column(nullable = false, length = 50)
    private String status;

    public Plantio(Talhao talhao, Cultura cultura, LocalDate dataPlantio, LocalDate dataColheitaPrevista, String status) {
        this.talhao = talhao;
        this.cultura = cultura;
        this.dataPlantio = dataPlantio;
        this.dataColheitaPrevista = dataColheitaPrevista;
        this.status = status;
    }
}