package br.com.sgee.gestaodeequipamentos.model;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Emprestimo")
@Getter
@Setter
public class Emprestimo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_funcionario")
    private Integer funcionario;

    @Column(name = "id_equipamento")
    private Integer equipamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEmprestimo statusEmprestimo;

    @CreationTimestamp
    @Column(name = "dataEmprestimo", nullable = false, updatable = false)
    private LocalDateTime dataEmprestimo;



    public Emprestimo(){}

}
