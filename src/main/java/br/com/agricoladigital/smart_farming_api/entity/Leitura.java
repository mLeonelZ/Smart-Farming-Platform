package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "leitura")
@Getter
@NoArgsConstructor
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_leitura")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dispositivo", nullable = false)
    private Dispositivo dispositivo;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(name = "origem_simulada", nullable = false)
    private Boolean origemSimulada;

    public Leitura(Dispositivo dispositivo, Double valor, LocalDateTime dataHora, Boolean origemSimulada) {
        this.dispositivo = dispositivo;
        this.valor = valor;
        this.dataHora = dataHora;
        this.origemSimulada = origemSimulada;
    }
}