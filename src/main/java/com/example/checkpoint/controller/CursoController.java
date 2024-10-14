package com.example.checkpoint.controller;

import com.example.checkpoint.dto.Curso.CursoRequest;
import com.example.checkpoint.dto.Curso.CursoResponse;
import com.example.checkpoint.model.Curso;
import com.example.checkpoint.repository.CursoRepository;
import com.example.checkpoint.service.CursoMapper;
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
@RequestMapping(value = "/cursos", produces = {"application/json"})
@Tag(name = "api-cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private CursoMapper cursoMapper;

    @Operation(summary = "Cria um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Curso criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Atributos inválidos fornecidos")
    })
    @PostMapping
    public ResponseEntity<CursoResponse> createCurso(@Valid @RequestBody CursoRequest cursoRequest) {
        Curso cursoConvertido = cursoMapper.requestRecordToCurso(cursoRequest);
        Curso cursoCriado = cursoRepository.save(cursoConvertido);
        CursoResponse cursoResponse = cursoMapper.cursoResponse(cursoCriado);
        return new ResponseEntity<>(cursoResponse, HttpStatus.CREATED);
    }

    @Operation(summary = "Busca todos os cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhum curso encontrado")
    })
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoRepository.findAll();
        if (cursos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @Operation(summary = "Busca um curso por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Atualiza um curso existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable long id, @Valid @RequestBody Curso cursoDetails) {
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if (cursoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Curso curso = cursoOptional.get();
        curso.setNome(cursoDetails.getNome());
        curso.setTipo(cursoDetails.getTipo());

        Curso cursoAtualizado = cursoRepository.save(curso);
        return ResponseEntity.ok(cursoAtualizado);
    }

    @Operation(summary = "Deleta um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Curso excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Curso não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable long id) {
        if (!cursoRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cursoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
