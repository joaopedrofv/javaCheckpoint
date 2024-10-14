package com.example.checkpoint.controller;

import com.example.checkpoint.model.Diplomado;
import com.example.checkpoint.repository.DiplomadoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diplomados")
@Tag(name = "api-diplomados")
public class DiplomadoController {

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    // Endpoint para criar um diplomado
    @Operation(summary = "Cria um diplomado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Diplomado criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Atributos inválidos fornecidos")
    })
    @PostMapping
    public ResponseEntity<Diplomado> createDiplomado(@Valid @RequestBody Diplomado diplomado) {
        Diplomado novoDiplomado = DiplomadoRepository.save(diplomado);
        return new ResponseEntity<>(novoDiplomado, HttpStatus.CREATED);
    }

    // Endpoint para obter todos os diplomados
    @Operation(summary = "Busca todos os diplomados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhum diplomado encontrado")
    })
    @GetMapping
    public ResponseEntity<List<Diplomado>> getAllDiplomados() {
        List<Diplomado> diplomados = diplomadoRepository.findAll();
        if (diplomados.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(diplomados, HttpStatus.OK);
    }

    // Endpoint para obter um diplomado por ID
    @Operation(summary = "Busca um diplomado por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Diplomado não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Diplomado> getDiplomadoById(@PathVariable long id) {
        Optional<Diplomado> diplomado = diplomadoRepository.findById(id);
        return diplomado.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para atualizar um diplomado
    @Operation(summary = "Atualiza um diplomado existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Diplomado atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Diplomado não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Diplomado> updateDiplomado(@PathVariable long id, @Valid @RequestBody Diplomado diplomadoDetails) {
        Optional<Diplomado> diplomadoOptional = diplomadoRepository.findById(id);
        if (diplomadoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Diplomado diplomado = diplomadoOptional.get();
        diplomado.setNome(diplomadoDetails.getNome());
        diplomado.setNacionalidade(diplomadoDetails.getNacionalidade());
        diplomado.setNaturalidade(diplomadoDetails.getNaturalidade());
        diplomado.setRg(diplomadoDetails.getRg());

        Diplomado diplomadoAtualizado = diplomadoRepository.save(diplomado);
        return ResponseEntity.ok(diplomadoAtualizado);
    }

    // Endpoint para deletar um diplomado
    @Operation(summary = "Deleta um diplomado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Diplomado excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Diplomado não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiplomado(@PathVariable long id) {
        if (!diplomadoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        diplomadoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
