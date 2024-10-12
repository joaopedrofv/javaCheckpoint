package com.example.checkpoint.dto.Diplomado;

import com.example.checkpoint.model.Diplomado;
import jakarta.validation.constraints.NotBlank;

public record DiplomadoRequest (
        @NotBlank(message = "O nome do diplomado é obrigatório")
        String nome,
        @NotBlank(message = "A nacionalidade do diplomado é obrigatória")
        String nacionalidade,
        @NotBlank(message = "A naturalidade do diplomado é obrigatória")
        String naturalidade,
        @NotBlank(message = "O rg do diplomado é obrigatório")
        String rg
){
}
