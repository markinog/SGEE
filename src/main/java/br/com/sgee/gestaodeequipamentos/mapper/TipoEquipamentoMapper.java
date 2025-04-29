package br.com.sgee.gestaodeequipamentos.mapper;

import br.com.sgee.gestaodeequipamentos.dto.TipoEquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoEquipamentoMapper {

    @Mapping(target = "nomeEquipamento", source = "request.nomeEquipamento")
    TipoEquipamento toTipoEquipamento(TipoEquipamentoRequest request);

    TipoEquipamentoRequest toRequest(TipoEquipamento tipoEquipamento);
}