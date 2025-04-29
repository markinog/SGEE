package br.com.sgee.gestaodeequipamentos.model;

import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "equipamento")

public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_equipamento")
    private Integer idEquipamento;

    @Column(name = "nome_equipamento", nullable = false, length = 150)
    private String nomeEquipamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_equipamento")
    private StatusEquipamento statusEquipamento;
}
