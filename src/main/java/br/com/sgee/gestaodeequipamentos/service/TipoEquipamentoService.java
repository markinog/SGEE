package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import br.com.sgee.gestaodeequipamentos.repository.TipoEquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoEquipamentoService {

    private final TipoEquipamentoRepository tipoEquipamentoRepository;

    public List<TipoEquipamento> listarTodos(){
        return tipoEquipamentoRepository.findAll();
    }



    public TipoEquipamento buscarPorTipoId(Integer idTipoEquipamento){
        return tipoEquipamentoRepository.findById(idTipoEquipamento).orElse(null);
    }

    public TipoEquipamento salvar(TipoEquipamento tipoEquipamento) {
        return tipoEquipamentoRepository.save(tipoEquipamento);
}


}
