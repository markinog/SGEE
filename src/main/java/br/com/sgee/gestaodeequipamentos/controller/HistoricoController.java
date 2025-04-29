package br.com.sgee.gestaodeequipamentos.controller;

import br.com.sgee.gestaodeequipamentos.dto.HistoricoFuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    public HistoricoService service;

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<List<HistoricoFuncionarioResponse>> buscarHistoricoFuncionario(String id) {
        List<HistoricoFuncionarioResponse> response = service.equipamentosPorFuncionario(id).stream()
                .map(equipamento -> HistoricoFuncionarioResponse.builder()
                        .nome(equipamento.getNome()).build())
                        .toList();
        return ResponseEntity.ok(response);
    }


}
