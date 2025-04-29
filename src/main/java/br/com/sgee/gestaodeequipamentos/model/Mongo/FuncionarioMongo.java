package br.com.sgee.gestaodeequipamentos.model.Mongo;

import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class FuncionarioMongo {


    private Integer funcionarioId;

    private String nome;

    private String matricula;

    private FuncionarioStatus status;


}
