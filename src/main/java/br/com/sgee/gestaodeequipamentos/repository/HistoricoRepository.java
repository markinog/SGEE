package br.com.sgee.gestaodeequipamentos.repository;

import br.com.sgee.gestaodeequipamentos.model.Historico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoricoRepository extends MongoRepository<Historico, String> {
}
