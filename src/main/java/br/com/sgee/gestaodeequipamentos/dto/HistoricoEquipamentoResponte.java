package br.com.sgee.gestaodeequipamentos.dto;

import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class HistoricoEquipamentoResponte {

    private String nome;
    private Integer id;
    private StatusEquipamento status;

}
