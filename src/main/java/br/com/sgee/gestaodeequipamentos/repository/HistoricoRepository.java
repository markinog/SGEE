package br.com.sgee.gestaodeequipamentos.repository;

import br.com.sgee.gestaodeequipamentos.model.Historico;
import br.com.sgee.gestaodeequipamentos.model.enums.TipoHistorico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends MongoRepository<Historico, String> {

    List<Historico> findByOperacaoAndFuncionarioFuncionarioId(TipoHistorico tipo, String id);
    List<Historico> findByOperacaoAndEquipamentoIdEquipamento(TipoHistorico tipo, String id);

}
