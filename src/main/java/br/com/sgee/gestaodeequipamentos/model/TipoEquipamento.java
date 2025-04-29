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

    @Column(name = "nome_tipo_equipamento", nullable = false, length = 100)
    private String nomeTipoEquipamento;


}
