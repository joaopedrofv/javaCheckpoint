package com.example.checkpoint.dto.Diploma;

import com.example.checkpoint.model.Curso;
import com.example.checkpoint.model.Diplomado;
import com.example.checkpoint.model.Sexo;

import java.util.Date;

public record DiplomaResponse(
    Long id,
    Diplomado diplomado,
    Curso curso,
    Date data,
    Sexo sexo,
    String nomeReitor
){
}
