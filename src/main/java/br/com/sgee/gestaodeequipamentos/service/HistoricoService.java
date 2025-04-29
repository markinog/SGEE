package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.model.Historico;
import br.com.sgee.gestaodeequipamentos.repository.HistoricoRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoricoService {

    private final HistoricoRepository repository;

    public HistoricoService (HistoricoRepository repository){
        this.repository = repository;
    }

    public void salvar(Historico historico){
        repository.save(historico);
    }

}
