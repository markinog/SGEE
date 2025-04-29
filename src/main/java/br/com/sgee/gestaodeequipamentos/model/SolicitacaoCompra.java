package br.com.sgee.gestaodeequipamentos.model;


import br.com.sgee.gestaodeequipamentos.dto.EquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "solicitar_compra")
public class SolicitacaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Funcionario solicitante;

    @ManyToOne
    private TipoEquipamento tipoEquipamento;

    private int quantidade;

    private boolean compra;

    private LocalDateTime dataCompra;


}

