package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
@Getter
@NoArgsConstructor
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_regra", nullable = false)
    private RegraAlerta regra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_talhao", nullable = false)
    private Talhao talhao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_leitura")
    private Leitura leitura;

    @Column(nullable = false, length = 100)
    private String tipo;

    @Column(name = "nivel_severidade", nullable = false, length = 50)
    private String nivelSeveridade;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 500)
    private String mensagem;

    @Column(nullable = false, length = 50)
    private String status;

    public Alerta(RegraAlerta regra, Talhao talhao, Leitura leitura, String tipo, String nivelSeveridade, LocalDateTime dataHora, String mensagem, String status) {
        this.regra = regra;
        this.talhao = talhao;
        this.leitura = leitura;
        this.tipo = tipo;
        this.nivelSeveridade = nivelSeveridade;
        this.dataHora = dataHora;
        this.mensagem = mensagem;
        this.status = status;
    }
}