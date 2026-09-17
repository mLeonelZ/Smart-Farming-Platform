package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "dispositivo")
@Getter
@NoArgsConstructor
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private Long id;

    @Column(name = "codigo_identificacao", nullable = false, unique = true, length = 100)
    private String codigoIdentificacao;

    @Column(name = "tipo_dispositivo", nullable = false, length = 50)
    private String tipoDispositivo;

    @Column(name = "data_instalacao")
    private LocalDate dataInstalacao;

    @Column(nullable = false, length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_talhao", nullable = false)
    private Talhao talhao;

    public Dispositivo(String codigoIdentificacao, String tipoDispositivo, LocalDate dataInstalacao, String status, Talhao talhao) {
        this.codigoIdentificacao = codigoIdentificacao;
        this.tipoDispositivo = tipoDispositivo;
        this.dataInstalacao = dataInstalacao;
        this.status = status;
        this.talhao = talhao;
    }
}