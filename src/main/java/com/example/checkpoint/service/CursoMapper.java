package com.example.checkpoint.service;

import com.example.checkpoint.dto.Curso.CursoRequest;
import com.example.checkpoint.dto.Curso.CursoResponse;
import com.example.checkpoint.model.Curso;
import org.springframework.stereotype.Service;

@Service
public class CursoMapper {

    public Curso requestRecordToCurso(CursoRequest cursoRequest){
        Curso curso = new Curso();
        curso.setNome(cursoRequest.nome());
        curso.setTipo(cursoRequest.tipo());
        return curso;
    }

    public CursoResponse cursoResponse(Curso curso){
        return new CursoResponse(
                curso.getId(),
                curso.getNome(),
                curso.getTipo()
        );
    }
}
