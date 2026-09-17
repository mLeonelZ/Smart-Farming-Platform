package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "talhao")
@Getter
@NoArgsConstructor
public class Talhao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_talhao")
    private Long id;

    @Column(nullable = false, length = 100)
    private String identificacao;

    @Column(name = "area_hectares", nullable = false)
    private Double areaHectares;

    @Column(length = 255)
    private String geometria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fazenda", nullable = false)
    private Fazenda fazenda;

    public Talhao(String identificacao, Double areaHectares, String geometria, Fazenda fazenda) {
        this.identificacao = identificacao;
        this.areaHectares = areaHectares;
        this.geometria = geometria;
        this.fazenda = fazenda;
    }
}