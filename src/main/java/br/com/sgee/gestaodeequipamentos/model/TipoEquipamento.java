package br.com.sgee.gestaodeequipamentos.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tipo_equipamento")
public class TipoEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_equipamento")
    private Integer idTipoEquipamento;

    @Column(name = "nome_tipo_equipamento")
    private String nomeEquipamento;

    @Column(name = "nome_tipo_equipamento", insertable=false, updatable=false)
    private String nomeEquipamentoTipo;

    private int quantidadeTotal;
    private int quantidadeDisponivel;

}
