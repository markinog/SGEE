package br.com.sgee.gestaodeequipamentos.mapper;

import br.com.sgee.gestaodeequipamentos.dto.TipoEquipamentoRequest;

import br.com.sgee.gestaodeequipamentos.dto.TipoEquipamentoResponse;
import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import org.springframework.stereotype.Component;

@Component
public class TipoEquipamentoMapper {

    public TipoEquipamento toTipoEquipamento(TipoEquipamentoRequest request) {
        return TipoEquipamento.builder()
                .nomeEquipamento(request.getNomeEquipamento())
                .build();
    }

    public TipoEquipamentoResponse toResponse(TipoEquipamento tipoEquipamento) {
        return TipoEquipamentoResponse.builder()
                .idTipoEquipamento(tipoEquipamento.getIdTipoEquipamento().longValue())
                .nomeEquipamento(tipoEquipamento.getNomeEquipamento())
                .build();
    }


}