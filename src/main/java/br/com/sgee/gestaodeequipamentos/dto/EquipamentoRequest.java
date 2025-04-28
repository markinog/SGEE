package br.com.sgee.gestaodeequipamentos.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EquipamentoRequest {

    private String nomeEquipamento;
    private String statusEquipamento;
}
