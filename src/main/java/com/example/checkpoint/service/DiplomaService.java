package com.example.checkpoint.service;

import com.example.checkpoint.model.Diploma;
import com.example.checkpoint.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiplomaService {

    @Autowired
    private DiplomaRepository diplomaRepository;

    public Diploma findById(UUID id) {
        return diplomaRepository.findById(id).orElse(null);
    }

    public Diploma saveDiploma(Diploma diploma) {
        return diplomaRepository.save(diploma);
    }

    public Diploma updateDiploma(UUID id, Diploma diplomaRequest) {
        Diploma diploma = findById(id);
        if (diploma != null) {
            diploma.setDiplomado(diplomaRequest.getDiplomado());
            diploma.setCurso(diplomaRequest.getCurso());
            diploma.setData(diplomaRequest.getData());
            diploma.setSexo(diplomaRequest.getSexo());
            diploma.setNomeReitor(diplomaRequest.getNomeReitor());
            return diplomaRepository.save(diploma);
        }
        return null;
    }

    public void deleteDiploma(UUID id) {
        diplomaRepository.deleteById(id);
    }
}
