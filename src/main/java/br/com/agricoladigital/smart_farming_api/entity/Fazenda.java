package br.com.agricoladigital.smart_farming_api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fazenda")
@Getter
@NoArgsConstructor
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fazenda")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 255)
    private String localizacao;

    @Column(name = "area_total", nullable = false)
    private Double areaTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public Fazenda(String nome, String localizacao, Double areaTotal, Usuario usuario) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.areaTotal = areaTotal;
        this.usuario = usuario;
    }
}