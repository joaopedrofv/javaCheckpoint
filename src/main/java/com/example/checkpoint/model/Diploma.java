package com.example.checkpoint.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "DIPLOMA")
public class Diploma {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(name = "diploma_diplomado")
    private Diplomado diplomado;
    @Column(name = "diploma_curso")
    private Curso curso;
    @Column(name = "diploma_data")
    private Date data;
    @Column(name = "diploma_sexo")
    private Sexo sexo;
    @Column(name = "diploma_nomeReitor")
    private String nomeReitor;

    public Diploma() {
    }

    public Diploma(Long id, Diplomado diplomado, Curso curso, Date data, Sexo sexo, String nomeReitor) {
        this.id = id;
        this.diplomado = diplomado;
        this.curso = curso;
        this.data = data;
        this.sexo = sexo;
        this.nomeReitor = nomeReitor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Diplomado getDiplomado() {
        return diplomado;
    }

    public void setDiplomado(Diplomado diplomado) {
        this.diplomado = diplomado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getNomeReitor() {
        return nomeReitor;
    }

    public void setNomeReitor(String nomeReitor) {
        this.nomeReitor = nomeReitor;
    }

    @Override
    public String toString() {
        return "Diploma{" +
                "id=" + id +
                ", diplomado=" + diplomado +
                ", curso=" + curso +
                ", data=" + data +
                ", sexo=" + sexo +
                ", nomeReitor='" + nomeReitor + '\'' +
                '}';
    }
}
