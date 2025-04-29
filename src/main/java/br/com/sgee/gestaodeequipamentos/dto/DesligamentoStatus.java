package br.com.sgee.gestaodeequipamentos.dto;

import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DesligamentoStatus {
    private Integer funcionarioId;
    private FuncionarioStatus status;
}
