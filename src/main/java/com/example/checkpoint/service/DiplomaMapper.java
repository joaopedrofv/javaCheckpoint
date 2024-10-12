package com.example.checkpoint.service;

import com.example.checkpoint.dto.Diploma.DiplomaRequest;
import com.example.checkpoint.dto.Diploma.DiplomaResponse;
import com.example.checkpoint.model.Diploma;
import org.springframework.stereotype.Service;

@Service
public class DiplomaMapper {

    public Diploma requestRecordToDiploma (DiplomaRequest diplomaRequest) {
        Diploma diploma = new Diploma();
        diploma.setDiplomado(diplomaRequest.diplomado());
        diploma.setCurso(diplomaRequest.curso());
        diploma.setData(diplomaRequest.data());
        diploma.setSexo(diplomaRequest.sexo());
        diploma.setNomeReitor(diplomaRequest.nomeReitor());
        return diploma;
    }

    public DiplomaResponse diplomaResponseDTO (Diploma diploma){
        return new DiplomaResponse(
                diploma.getId(),
                diploma.getDiplomado(),
                diploma.getCurso(),
                diploma.getData(),
                diploma.getSexo(),
                diploma.getNomeReitor()
        );
    }
}
