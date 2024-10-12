package com.example.checkpoint.service;

import com.example.checkpoint.dto.Diplomado.DiplomadoRequest;
import com.example.checkpoint.dto.Diplomado.DiplomadoResponse;
import com.example.checkpoint.model.Diplomado;
import org.springframework.stereotype.Service;

@Service
public class DiplomadoMapper {

    public Diplomado requestRecordToDiplomado(DiplomadoRequest diplomadoRequest){
        Diplomado diplomado = new Diplomado();
        diplomado.setNome(diplomadoRequest.nome());
        diplomado.setNacionalidade(diplomadoRequest.nacionalidade());
        diplomado.setNaturalidade(diplomadoRequest.naturalidade());
        diplomado.setRg(diplomadoRequest.rg());
        return diplomado;
    }

    public DiplomadoResponse diplomadoResponse(Diplomado diplomado){
        return new DiplomadoResponse(
                diplomado.getId(),
                diplomado.getNome(),
                diplomado.getNacionalidade(),
                diplomado.getNaturalidade(),
                diplomado.getRg()
        );
    }
}
