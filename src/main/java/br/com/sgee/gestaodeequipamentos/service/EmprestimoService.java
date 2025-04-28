package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.model.Emprestimo;
import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import br.com.sgee.gestaodeequipamentos.repository.EmprestimoRepository;
import br.com.sgee.gestaodeequipamentos.repository.EquipamentoRepository;
import br.com.sgee.gestaodeequipamentos.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final EquipamentoRepository equipamentoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final HistoricoService historicoService;

    public Emprestimo criarEmprestimo(Integer funcionarioId, List<Integer> equipamentosIds) {
        Funcionario funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new RuntimeException("Funcionário não cadastrado"));

        List<Equipamento> equipamentos = equipamentoRepository.findAllById(equipamentosIds);

        if (equipamentos.size() != equipamentosIds.size()) {
            throw new RuntimeException("Algum equipamento não foi encontrado");
        }

        for (Equipamento equipamento : equipamentos) {
            if (!equipamento.getStatusEquipamento().equals(StatusEquipamento.DISPONIVEL)) {
                throw new RuntimeException("Equipamento " + equipamento.getNomeEquipamento() + " não está disponível");
            }
        }

        for (Equipamento equipamento : equipamentos) {
            equipamento.setStatusEquipamento(StatusEquipamento.DISPONIVEL);
        }
        equipamentoRepository.saveAll(equipamentos);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setFuncionario(funcionario);
        emprestimo.setEquipamentos(equipamentos);
        emprestimo.setDataEmprestimo(LocalDateTime.now());

        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);

//        for (Equipamento equipamento : equipamentos) {
//            historicoService.registrarMovimentacao(funcionario, equipamento, "EMPRESTIMO");
//        }

        return emprestimoSalvo;
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }
}
