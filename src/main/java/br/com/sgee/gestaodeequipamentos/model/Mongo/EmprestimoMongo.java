package br.com.sgee.gestaodeequipamentos.model.Mongo;


import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class EmprestimoMongo {


    private Integer id;

    private Integer funcionario;

    private Integer equipamento;

    private StatusEmprestimo statusEmprestimo;

    private LocalDateTime dataEmprestimo;


}
