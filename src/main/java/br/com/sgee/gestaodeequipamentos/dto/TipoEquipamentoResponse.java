package br.com.sgee.gestaodeequipamentos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TipoEquipamentoResponse {

    private Long idTipoEquipamento;
    private String nomeEquipamento;

}