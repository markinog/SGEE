package br.com.sgee.gestaodeequipamentos.dto;

import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
public class EmprestimoRequest {

    private Integer funcionarioId;
    private List<Integer> equipamentosId;
    private Integer tipoEquipamentoId;
    private Integer quantidade;
    private StatusEmprestimo statusEmprestimo;

}
