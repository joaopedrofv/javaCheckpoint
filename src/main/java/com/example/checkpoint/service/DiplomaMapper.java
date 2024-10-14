package com.example.checkpoint.service;

import com.example.checkpoint.dto.Diploma.DiplomaRequest;
import com.example.checkpoint.dto.Diploma.DiplomaResponse;
import com.example.checkpoint.model.Diploma;
import com.example.checkpoint.model.Sexo;
import org.springframework.stereotype.Service;

@Service
public class DiplomaMapper {

    public Diploma requestRecordToDiploma(DiplomaRequest diplomaRequest) {
        Diploma diploma = new Diploma();
        diploma.setDiplomado(diplomaRequest.diplomado());
        diploma.setCurso(diplomaRequest.curso());
        diploma.setData(diplomaRequest.data());
        diploma.setSexo(diplomaRequest.sexo());
        diploma.setNomeReitor(diplomaRequest.nomeReitor());
        return diploma;
    }

    public String diplomaResponseDTO(Diploma diploma) {
        String tituloReitor = gerarTituloReitor(diploma.getSexo(), diploma.getNomeReitor());
        String cargoReitor = gerarCargoReitor(diploma.getSexo());

        return String.format(
                "O %s, %s da Universidade Fake, no uso de suas atribuições, confere a %s, de nacionalidade %s, natural de %s, portador do rg %s, o presente diploma de %s, do curso de %s, por ter concluído seus estudos nesta instituição de ensino no dia %s.",
                tituloReitor,
                cargoReitor,
                diploma.getDiplomado().getNome(),
                diploma.getDiplomado().getNacionalidade(),
                diploma.getDiplomado().getNaturalidade(),
                diploma.getDiplomado().getRg(),
                diploma.getCurso().getTipo().toString(),
                diploma.getCurso().getNome(),
                diploma.getData().toString()
        );
    }

    private String gerarTituloReitor(Sexo sexo, String nomeReitor) {
        if (sexo == Sexo.M) {
            return "Prof. Dr. " + nomeReitor;
        } else {
            return "Profa. Dra. " + nomeReitor;
        }
    }

    private String gerarCargoReitor(Sexo sexo) {
        return (sexo == Sexo.M) ? "reitor" : "reitora";
    }
}



