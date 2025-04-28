package br.com.sgee.gestaodeequipamentos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "historico_emprestimo")
public class Historico {
    @Id
    private int id;

    @JoinColumn(name = "id_equipamentos")
    private int idEquipamento;
    @JoinColumn(name ="id_funcionario")
    private int idFuncionario;
    @Column(name ="descricao", length = 255)
    private String descricao;
    @Column(name ="status")
    private String status;
}
