package br.com.sgee.gestaodeequipamentos.controller;

import br.com.sgee.gestaodeequipamentos.dto.FuncionarioRequest;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import br.com.sgee.gestaodeequipamentos.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
