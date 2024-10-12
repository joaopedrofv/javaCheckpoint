package com.example.checkpoint.dto.Diploma;

import com.example.checkpoint.model.Curso;
import com.example.checkpoint.model.Diplomado;
import com.example.checkpoint.model.Sexo;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record DiplomaRequest(
    @NotBlank(message = "O diplomado é obrigatório")
    Diplomado diplomado,
    @NotBlank(message = "O curso é obrigatório")
    Curso curso,
    @NotBlank(message = "A data é obrigatória")
    Date data,
    @NotBlank(message = "O sexo é obrigatório")
    Sexo sexo,
    @NotBlank(message = "O nome do reitor(A) é obrigatório")
    String nomeReitor
){

}






