package br.com.sgee.gestaodeequipamentos.dto;

import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FuncionarioRequest {

    private String matricula;
    private String nome;
    private FuncionarioStatus status;

}
