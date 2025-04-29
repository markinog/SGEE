package br.com.sgee.gestaodeequipamentos.dto;

import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PendenciaStatus {
    private Integer equipamentoId;
    private StatusEmprestimo statusEmprestimo;
}
