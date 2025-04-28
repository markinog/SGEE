package br.com.sgee.gestaodeequipamentos.mapper;

import br.com.sgee.gestaodeequipamentos.dto.EquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.dto.EquipamentoResponse;
import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import org.springframework.stereotype.Component;

@Component
public class EquipamentoMapper {

    public Equipamento toEquipamento(EquipamentoRequest request) {
        return Equipamento.builder()
                .nomeEquipamento(request.getNomeEquipamento())
                .statusEquipamento(StatusEquipamento.valueOf(request.getStatusEquipamento()))
                .build();
    }

    public EquipamentoResponse toResponse(Equipamento equipamento) {
        return EquipamentoResponse.builder()
                .idEquipamento(equipamento.getIdEquipamento())
                .build();
    }
}