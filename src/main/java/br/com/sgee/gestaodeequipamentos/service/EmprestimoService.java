package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.EmprestimoRequest;
import br.com.sgee.gestaodeequipamentos.model.Emprestimo;
import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import br.com.sgee.gestaodeequipamentos.repository.EmprestimoRepository;
import br.com.sgee.gestaodeequipamentos.repository.EquipamentoRepository;
import br.com.sgee.gestaodeequipamentos.repository.FuncionarioRepository;
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


    public List<Emprestimo> criarEmprestimo(EmprestimoRequest request) {
        Funcionario funcionario = funcionarioService.get(request.getFuncionarioId());

        List<Equipamento> equipamentos = equipamentoService.getEquipamentos(request.getEquipamentosId());

        if (equipamentos.size() != request.getEquipamentosId().size()) {
            throw new RuntimeException("Algum equipamento não foi encontrado");
        }

        List<Emprestimo> emprestimos = new ArrayList<>();
        for (Equipamento equipamento : equipamentos) {
            if (!equipamento.getStatusEquipamento().equals(StatusEquipamento.DISPONIVEL)) {
                throw new RuntimeException("Equipamento " + equipamento.getNomeEquipamento() + " não está disponível");
            }

            equipamentoService.atualizarEquipamento(equipamento.getIdEquipamento(),StatusEquipamento.EM_USO);

            Emprestimo emprestimo = new Emprestimo();
                    emprestimo.setFuncionario(request.getFuncionarioId());
                    emprestimo.setStatusEmprestimo(StatusEmprestimo.ANDAMENTO);
                    emprestimo.setEquipamento(equipamento.getIdEquipamento());
                    emprestimos.add(emprestimoRepository.save(emprestimo));

        }

        return emprestimos;

        }
    }

