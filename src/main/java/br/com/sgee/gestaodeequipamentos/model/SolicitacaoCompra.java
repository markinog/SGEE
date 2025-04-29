package br.com.sgee.gestaodeequipamentos.model;

import br.com.sgee.gestaodeequipamentos.model.enums.StatusSolicitacaoCompra;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "solicitacao_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SolicitacaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeEquipamentoSolicitado;

    @Column(nullable = false)
    private Integer quantidadeSolicitada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusSolicitacaoCompra statusSolicitacao;

    private LocalDateTime dataSolicitacao;

    private LocalDateTime dataConclusao;

    @OneToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimoRelacionado;
}
