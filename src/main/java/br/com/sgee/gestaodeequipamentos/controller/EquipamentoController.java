package br.com.sgee.gestaodeequipamentos.controller;

import br.com.sgee.gestaodeequipamentos.dto.EquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.dto.EquipamentoResponse;
import br.com.sgee.gestaodeequipamentos.service.EquipamentoService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipamentos")
@RequiredArgsConstructor
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<EquipamentoResponse> criarEquipamento(@RequestBody EquipamentoRequest request) {
        EquipamentoResponse response = equipamentoService.criarEquipamento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{idEquipamento}")
    public ResponseEntity<EquipamentoResponse> buscarPorId(@PathVariable Integer idEquipamento) {
        EquipamentoResponse response = equipamentoService.buscarPorId(idEquipamento);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> listarTodos() {
        List<EquipamentoResponse> equipamentos = equipamentoService.listarTodos();
        return ResponseEntity.ok(equipamentos);
    }

    @DeleteMapping("/{idEquipamento}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable Integer idEquipamento) {
        equipamentoService.deletarEquipamento(idEquipamento);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}