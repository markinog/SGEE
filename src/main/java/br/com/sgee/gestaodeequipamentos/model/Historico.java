package br.com.sgee.gestaodeequipamentos.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historico")
@Data

public class Historico {

    @Id
    private String id;

    private Funcionario funcionario;

    private Equipamento equipamento;


    private Emprestimo emprestimo;

}
