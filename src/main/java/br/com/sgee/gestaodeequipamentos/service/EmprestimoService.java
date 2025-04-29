package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.EmprestimoRequest;
import br.com.sgee.gestaodeequipamentos.dto.TipoEquipamentoRequest;
import br.com.sgee.gestaodeequipamentos.model.*;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import br.com.sgee.gestaodeequipamentos.repository.EmprestimoRepository;
import br.com.sgee.gestaodeequipamentos.repository.EquipamentoRepository;
import br.com.sgee.gestaodeequipamentos.repository.FuncionarioRepository;
import br.com.sgee.gestaodeequipamentos.repository.TipoEquipamentoRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final EquipamentoService equipamentoService;
    private final FuncionarioService funcionarioService;
    private final HistoricoService historicoService;
    private final TipoEquipamentoRepository tipoEquipamentoRepository;


    public List<Emprestimo> criarEmprestimo(EmprestimoRequest request, TipoEquipamentoRequest tipoEquipamentoRequest) {
        Funcionario funcionario = funcionarioService.get(request.getFuncionarioId());
        TipoEquipamento tipoEquip = tipoEquipamentoRepository.findById(request.getTipoEquipamentoId())
                .orElseThrow(() -> new RuntimeException("Tipo de equipamento não encontrado"));


        if (tipoEquipamentoRequest.getQuantidadeDisponivel() >= tipoEquipamentoRequest.getQuantidadeTotal()) {
            tipoEquip.setQuantidadeDisponivel(tipoEquip.getQuantidadeDisponivel() - request.getQuantidade());
            tipoEquipamentoRepository.save(tipoEquip);
        }

        List<Equipamento> equipamentos = equipamentoService.getEquipamentos(request.getEquipamentosId());

        if (equipamentos.size() != request.getEquipamentosId().size()) {
            //equipamento não encontrado
            throw new RuntimeException("Algum equipamento não foi encontrado");
        }

        List<Emprestimo> emprestimos = new ArrayList<>();
        for (Equipamento equipamento : equipamentos) {
            if (!equipamento.getStatusEquipamento().equals(StatusEquipamento.DISPONIVEL)) {
                //se n estiver disponivel lanca essa exceção
                throw new RuntimeException("Equipamento " + equipamento.getNomeEquipamento() + " não está disponível");
            }

            equipamentoService.atualizarEquipamento(equipamento.getIdEquipamento(),StatusEquipamento.EM_USO);

            for(int i = 0; i <= request.getQuantidade(); i++){
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setFuncionario(request.getFuncionarioId());
                emprestimo.setStatusEmprestimo(StatusEmprestimo.ANDAMENTO);
                emprestimo.setEquipamento(equipamento.getIdEquipamento());
                emprestimos.add(emprestimoRepository.save(emprestimo));


                Historico historico = new Historico();
                historico.setEmprestimo(emprestimo);
                historico.setFuncionario(funcionario);
                historico.setEquipamento(equipamento);


                historicoService.salvar(historico);
            }
        }

        return emprestimos;

        }
    }

