package br.com.sgee.gestaodeequipamentos.model;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Emprestimo")
@Getter
@Setter
public class Emprestimo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @JoinTable(
            name = "emprestimo_equipamento",
            joinColumns = @JoinColumn(name = "emprestimo_id"),
            inverseJoinColumns = @JoinColumn(name = "equipamento_id")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Equipamento> equipamentos;

    @Column(name = "dataEmprestimo")
    private LocalDateTime dataEmprestimo;

    @Column(name = "dataDevolucao")
    private LocalDateTime dataDevolucao;

    public Emprestimo(){}

}
