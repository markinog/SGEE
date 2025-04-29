package br.com.sgee.gestaodeequipamentos.model;

import br.com.sgee.gestaodeequipamentos.repository.HistoricoRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "historico")
@Getter
@Setter
public class Historico {

    private HistoricoRepository repository;

    public Historico(HistoricoRepository repository){
        this.repository = repository;
    }

    @Id
    private String id;

    private Funcionario funcionario;

    private Equipamento equipamento;




}
