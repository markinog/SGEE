package br.com.sgee.gestaodeequipamentos.controller;


import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import br.com.sgee.gestaodeequipamentos.service.TipoEquipamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tipos-equipamento")
@AllArgsConstructor

public class TipoEquipamentoController {


    private final TipoEquipamentoService tipoEquipamentoService;

    @GetMapping
    public List<TipoEquipamento> listarTodos() {
        return tipoEquipamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public TipoEquipamento buscarPorTipoId(@PathVariable Integer idTipoEquipamento) {
        return tipoEquipamentoService.buscarPorTipoId(idTipoEquipamento);
}


}
