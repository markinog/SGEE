package br.com.sgee.gestaodeequipamentos.controller;


import br.com.sgee.gestaodeequipamentos.dto.TipoEquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.mapper.TipoEquipamentoMapper;
import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import br.com.sgee.gestaodeequipamentos.service.TipoEquipamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-equipamento")
@AllArgsConstructor

public class TipoEquipamentoController {


    private final TipoEquipamentoService tipoEquipamentoService;
    private final TipoEquipamentoMapper tipoEquipamentoMapper;

    @PostMapping
    public ResponseEntity<TipoEquipamento> salvar(@RequestBody TipoEquipamentoRequest request) {
        TipoEquipamento tipoEquipamento = tipoEquipamentoMapper.toTipoEquipamento(request);
        TipoEquipamento salvo = tipoEquipamentoService.salvar(tipoEquipamento);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public List<TipoEquipamento> listarTodos() {
        return tipoEquipamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public TipoEquipamento buscarPorTipoId(@PathVariable("id") Integer id) {
        return tipoEquipamentoService.buscarPorTipoId(id);
}


}
