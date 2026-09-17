package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estacao_meteorologica")
@Getter
@NoArgsConstructor
public class EstacaoMeteorologica {

    @Id
    @Column(name = "id_dispositivo")
    private Long id;

    // Usa o mesmo ID do Dispositivo como PK e FK
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;

    @Column(length = 100)
    private String modelo;

    @Column(name = "frequencia_coleta")
    private Integer frequenciaColeta;

    public EstacaoMeteorologica(
            Dispositivo dispositivo,
            String modelo,
            Integer frequenciaColeta
    ) {
        this.dispositivo = dispositivo;
        this.modelo = modelo;
        this.frequenciaColeta = frequenciaColeta;
    }
}