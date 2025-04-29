package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.EmprestimoRequest;
import br.com.sgee.gestaodeequipamentos.dto.EquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.dto.EquipamentoResponse;
import br.com.sgee.gestaodeequipamentos.mapper.EquipamentoMapper;
import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import br.com.sgee.gestaodeequipamentos.repository.EquipamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper equipamentoMapper;

    @Transactional
    public EquipamentoResponse criarEquipamento(EquipamentoRequest request) {
        Equipamento equipamento = equipamentoMapper.toEquipamento(request);
        Equipamento equipamentoSalvo = equipamentoRepository.save(equipamento);
        return equipamentoMapper.toResponse(equipamentoSalvo);
    }

    @Transactional(readOnly = true)
    public EquipamentoResponse buscarPorId(Integer idEquipamento) {
        return equipamentoRepository.findById(idEquipamento)
                .map(equipamentoMapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("Equipamento não encontrado com ID: " + idEquipamento));
    }

    @Transactional(readOnly = true)
    public List<EquipamentoResponse> listarTodos() {
        return equipamentoRepository.findAll()
                .stream()
                .map(equipamentoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletarEquipamento(Integer idEquipamento) {
        if (!equipamentoRepository.existsById(idEquipamento)) {
            throw new EntityNotFoundException("Equipamento não encontrado com ID: " + idEquipamento);
        }
        equipamentoRepository.deleteById(idEquipamento);
    }

    public List<Equipamento> getEquipamentos(List<Integer> equipamentosIds){

        return equipamentoRepository.findAllById(equipamentosIds);

    }

    public List<Equipamento> salvarEquipamentos(List<Equipamento> equipamentos){
        return equipamentoRepository.saveAll(equipamentos);
    }

    public Equipamento atualizarEquipamento(Integer id, StatusEquipamento statusEquipamento){
        Equipamento equip  = equipamentoRepository.getById(id);
        equip.setStatusEquipamento(statusEquipamento);
        return equipamentoRepository.save(equip);
    }


}
