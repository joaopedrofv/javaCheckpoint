package com.example.checkpoint.dto.Curso;

import com.example.checkpoint.model.Tipo;
import jakarta.validation.constraints.NotBlank;

public record CursoRequest (
    @NotBlank(message = "O nome do curso é obrigatório")
    String nome,
    @NotBlank(message = "O tipo do curso é obrigatório")
    Tipo tipo
){
}
