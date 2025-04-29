package br.com.sgee.gestaodeequipamentos.model.Mongo;

import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EquipamentoMongo {


    private Integer idEquipamento;

    private String nomeEquipamento;

    private StatusEquipamento statusEquipamento;

}
