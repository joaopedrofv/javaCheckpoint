package com.example.checkpoint.controller;

import com.example.checkpoint.model.Diploma;
import com.example.checkpoint.service.DiplomaMapper;
import com.example.checkpoint.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/diploma")
public class DiplomaController {

    @Autowired
    private DiplomaService diplomaService;

    @Autowired
    private DiplomaMapper diplomaMapper;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<String> getDiploma(@PathVariable UUID id) {
        Diploma diploma = diplomaService.findById(id);
        if (diploma != null) {
            String textoDiploma = diplomaMapper.diplomaResponseDTO(diploma);
            return ResponseEntity.ok(textoDiploma);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Diploma> createDiploma(@RequestBody Diploma diplomaRequest) {
        Diploma savedDiploma = diplomaService.saveDiploma(diplomaRequest);
        return ResponseEntity.ok(savedDiploma);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Diploma> updateDiploma(@PathVariable UUID id, @RequestBody Diploma diplomaRequest) {
        Diploma updatedDiploma = diplomaService.updateDiploma(id, diplomaRequest);
        return ResponseEntity.ok(updatedDiploma);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDiploma(@PathVariable UUID id) {
        diplomaService.deleteDiploma(id);
        return ResponseEntity.noContent().build();
    }
}
