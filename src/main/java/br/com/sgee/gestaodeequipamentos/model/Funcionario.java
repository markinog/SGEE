package br.com.sgee.gestaodeequipamentos.model;

import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@Builder
public class Funcionario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FuncionarioId;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "matricula", nullable = false, length = 30)
    private String matricula;

    @Column(name = "status")
    private FuncionarioStatus status;

    @OneToMany(mappedBy = "funcionario")
    List<Equipamento> equipamentos;

}

