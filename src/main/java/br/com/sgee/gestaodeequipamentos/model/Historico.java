package br.com.sgee.gestaodeequipamentos.model;


import br.com.sgee.gestaodeequipamentos.model.Mongo.FuncionarioMongo;
import br.com.sgee.gestaodeequipamentos.model.enums.TipoHistorico;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historico")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Historico {

    @Id
    private String id;

    private FuncionarioMongo funcionario;

    private Equipamento equipamento;

    private Emprestimo emprestimo;

    private TipoHistorico operacao;

}
