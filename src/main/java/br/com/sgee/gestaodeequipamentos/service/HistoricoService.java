package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.HistoricoEquipamentoResponte;
import br.com.sgee.gestaodeequipamentos.dto.HistoricoFuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.Historico;
import br.com.sgee.gestaodeequipamentos.model.enums.TipoHistorico;
import br.com.sgee.gestaodeequipamentos.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoService {

    private final HistoricoRepository repository;

    public HistoricoService(HistoricoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Historico historico) {
        repository.save(historico);
    }

    public List<HistoricoEquipamentoResponte> equipamentosPorFuncionario(String id) {

        List<Historico> historico = repository.findByOperacaoAndFuncionarioFuncionarioId(TipoHistorico.EMPRESTIMO, id);
        return historico.stream().map(h -> {
            return HistoricoEquipamentoResponte.builder()
                    .nome(h.getEquipamento().getNomeEquipamento())
                    .id(h.getEquipamento().getIdEquipamento())
                    .status(h.getEquipamento().getStatusEquipamento())
                    .build();
        }).toList();
    }


}

