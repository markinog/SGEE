package br.com.sgee.gestaodeequipamentos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TipoEquipamentoRequest {

    private String nome;
    private int quantidadeTotal;
    private int quantidadeDisponivel;

}
