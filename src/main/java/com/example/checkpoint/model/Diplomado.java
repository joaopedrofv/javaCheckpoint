package com.example.checkpoint.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "DIPLOMADO")
public class Diplomado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "diplomado_nome")
    private String nome;
    @Column(name = "diplomado_nacionalidade")
    private String nacionalidade;
    @Column(name = "diplomado_naturalidade")
    private String naturalidade;
    @Column(name = "diplomado_rg")
    private String rg;

    public Diplomado() {
    }

    public Diplomado(long id, String nome, String nacionalidade, String naturalidade, String rg) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.rg = rg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Diplomado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", naturalidade='" + naturalidade + '\'' +
                ", rg='" + rg + '\'' +
                '}';
    }
}
