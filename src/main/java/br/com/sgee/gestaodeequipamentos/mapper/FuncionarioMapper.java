package br.com.sgee.gestaodeequipamentos.mapper;

import br.com.sgee.gestaodeequipamentos.dto.FuncionarioRequest;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.Mongo.FuncionarioMongo;
import org.springframework.stereotype.Component;

import java.util.List;

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
                .nome(funcionario.getNome())
                .build();
    }

    public List<FuncionarioResponse> toResponseList(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(this::toResponse)
                .toList();
    }

    public FuncionarioMongo funcionarioMongo(Funcionario funcionario){
        return FuncionarioMongo.builder()
                .funcionarioId(funcionario.getFuncionarioId())
                .matricula(funcionario.getMatricula())
                .nome(funcionario.getNome())
                .status(funcionario.getStatus())
                .build();
    }



}
