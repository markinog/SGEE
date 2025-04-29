package br.com.sgee.gestaodeequipamentos.model;

import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private FuncionarioStatus status;


}

