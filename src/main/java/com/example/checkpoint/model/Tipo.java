package com.example.checkpoint.model;

public enum Tipo {
    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós Graduação");

    private String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
