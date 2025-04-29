package br.com.sgee.gestaodeequipamentos.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@Entity
@Table(name = "tipo_equipamento")
@Builder
public class TipoEquipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_equipamento")
    private Integer idTipoEquipamento;

    @Column(name = "nome_tipo_equipamento")
    private String nomeEquipamento;

    private int quantidadeTotal;
    private int quantidadeDisponivel;

}
