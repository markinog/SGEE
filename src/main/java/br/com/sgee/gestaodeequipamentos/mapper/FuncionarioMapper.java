package br.com.sgee.gestaodeequipamentos.mapper;

import br.com.sgee.gestaodeequipamentos.dto.FuncionarioRequest;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario toFuncionario (FuncionarioRequest request){

        return  Funcionario.builder()
                .nome(request.getNome())
                .matricula(request.getMatricula())
                .status(request.getStatus())
                .build();

    }

    public FuncionarioResponse toResponse(Funcionario funcionario){

        return FuncionarioResponse.builder()
                .id(funcionario.getFuncionarioId())
                .build();
    }

}
