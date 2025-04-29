package br.com.sgee.gestaodeequipamentos.controller;

import br.com.sgee.gestaodeequipamentos.dto.DesligamentoStatus;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioPendencia;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioRequest;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import br.com.sgee.gestaodeequipamentos.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {


    private FuncionarioService service;

    public FuncionarioController(FuncionarioService funcionarioService){
        this.service = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> salvar(@RequestBody FuncionarioRequest request){
        return ResponseEntity.ok(service.salvar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Integer id) {
        FuncionarioResponse response = service.buscarPorId(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> listarTodos() {
        List<FuncionarioResponse> response = service.listarTodos();
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}/atualizar-dados")
    public ResponseEntity<FuncionarioResponse> atualizar(@PathVariable Integer id, @RequestBody FuncionarioRequest request) {
        FuncionarioResponse response = service.atualizar(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/deletar-conta")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<FuncionarioResponse>> listarPorStatus(@PathVariable FuncionarioStatus status) {
        List<FuncionarioResponse> response = service.listarPorStatus(status);
        return ResponseEntity.ok(response);
}

    @PostMapping("/{id}/desligamento")
    public ResponseEntity<Void> solicitarDesligamento(@PathVariable Integer id) {
        service.solicitarDesligamento(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}/consultar-status")
    public ResponseEntity<DesligamentoStatus> consultarStatusFuncionario(@PathVariable Integer id) {
        return ResponseEntity.ok(service.consultarStatusDesligamento(id));
    }

    @GetMapping("/pendencias")
    public ResponseEntity<List<FuncionarioPendencia>> listarFuncionariosComPendencias() {
        return ResponseEntity.ok(service.listarFuncionariosComPendencias());
    }

}
