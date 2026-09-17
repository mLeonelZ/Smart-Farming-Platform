package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sensor")
@Getter
@NoArgsConstructor
public class Sensor {

    @Id
    @Column(name = "id_dispositivo")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId // Usa o mesmo ID do Dispositivo como PK e FK do Sensor
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;

    @Column(name = "tipo_sensor", nullable = false, length = 100)
    private String tipoSensor;

    @Column(name = "unidade_medida", nullable = false, length = 50)
    private String unidadeMedida;

    public Sensor(
            Dispositivo dispositivo,
            String tipoSensor,
            String unidadeMedida
    ) {
        this.dispositivo = dispositivo;
        this.tipoSensor = tipoSensor;
        this.unidadeMedida = unidadeMedida;
    }
}