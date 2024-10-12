package com.example.checkpoint.dto.Curso;

import com.example.checkpoint.model.Tipo;

public record CursoResponse (
    Long id,
    String nome,
    Tipo tipo
){
}



