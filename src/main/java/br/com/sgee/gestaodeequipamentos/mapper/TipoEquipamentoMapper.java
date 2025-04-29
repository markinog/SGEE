package br.com.sgee.gestaodeequipamentos.mapper;

import br.com.sgee.gestaodeequipamentos.dto.TipoEquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoEquipamentoMapper {

    // Fields com mesmo nome (nomeEquipamento, quantidadeTotal, quantidadeDisponivel)
    // serão mapeados automaticamente
    TipoEquipamento toTipoEquipamento(TipoEquipamentoRequest request);

    TipoEquipamentoRequest toRequest(TipoEquipamento tipoEquipamento);
}