package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cultura")
@Getter
@NoArgsConstructor
public class Cultura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cultura")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "tipo_plantio", length = 100)
    private String tipoPlantio;

    @Column(name = "ciclo_dias")
    private Integer cicloDias;

    public Cultura(String nome, String tipoPlantio, Integer cicloDias) {
        this.nome = nome;
        this.tipoPlantio = tipoPlantio;
        this.cicloDias = cicloDias;
    }
}