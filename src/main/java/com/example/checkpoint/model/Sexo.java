package com.example.checkpoint.model;

public enum Sexo {
    M("Masculino"),
    F("Feminino");

    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return sexo;
    }
}
