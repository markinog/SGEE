package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.FuncionarioRequest;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.mapper.FuncionarioMapper;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioResponse salvar(FuncionarioRequest request){

        Funcionario f1 = mapper.toFuncionario(request);
        Funcionario funcionario = repository.save(f1);

        return mapper.toResponse(funcionario);
    }


}
