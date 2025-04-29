package br.com.sgee.gestaodeequipamentos.controller;

import br.com.sgee.gestaodeequipamentos.dto.EmprestimoRequest;
import br.com.sgee.gestaodeequipamentos.model.Emprestimo;
import br.com.sgee.gestaodeequipamentos.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("emprestimo")
public class EmprestimoController {

    @Autowired
    public EmprestimoService service;

    public

    @PostMapping
    ResponseEntity<List<Emprestimo>> salvar(@RequestBody EmprestimoRequest request) {
        List<Emprestimo> emprestimos = service.criarEmprestimo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimos);
    }


}
