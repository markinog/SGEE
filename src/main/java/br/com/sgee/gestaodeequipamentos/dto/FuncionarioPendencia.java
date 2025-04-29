package br.com.sgee.gestaodeequipamentos.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class FuncionarioPendencia {
    private Integer funcionarioId;
    private String nome;
    private List<PendenciaStatus> pendencias;
}
