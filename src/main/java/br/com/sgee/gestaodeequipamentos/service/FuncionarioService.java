package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.*;
import br.com.sgee.gestaodeequipamentos.mapper.FuncionarioMapper;
import br.com.sgee.gestaodeequipamentos.model.Emprestimo;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import br.com.sgee.gestaodeequipamentos.repository.EmprestimoRepository;
import br.com.sgee.gestaodeequipamentos.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;
    private final EmprestimoRepository emprestimoRepository;

    public FuncionarioResponse salvar(FuncionarioRequest request){

        Funcionario f1 = mapper.toFuncionario(request);
        Funcionario funcionario = repository.save(f1);

        return mapper.toResponse(funcionario);
    }

    public Funcionario get(Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não cadastrado"));
    }

    public FuncionarioResponse buscarPorId(Integer id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        return mapper.toResponse(funcionario);
    }

    public List<FuncionarioResponse> listarTodos() {
        List<Funcionario> funcionarios = repository.findAll();
        return mapper.toResponseList(funcionarios);
    }

    public void deletar(Integer id) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        repository.delete(funcionario);

    }

    public List<FuncionarioResponse> listarPorStatus(FuncionarioStatus status) {

        List<Funcionario> funcionarios = repository.findByStatus(status);
        if (funcionarios.isEmpty()) {
            throw new RuntimeException("Nenhum funcionário encontrado com o status: " + status);
        }
        return mapper.toResponseList(funcionarios);
    }

    public FuncionarioResponse atualizar(Integer id, FuncionarioRequest request) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        funcionario.setNome(request.getNome());
        funcionario.setMatricula(request.getMatricula());
        funcionario.setStatus(request.getStatus());

        Funcionario updatedFuncionario = repository.save(funcionario);

        return mapper.toResponse(updatedFuncionario);
    }

    public void solicitarDesligamento(Integer id) {
        var f = get(id);
        f.setStatus(FuncionarioStatus.AFASTADO);
        repository.save(f);
    }

    public DesligamentoStatus consultarStatusDesligamento(Integer id) {
        var f = get(id);
        return DesligamentoStatus.builder()
                .funcionarioId(f.getFuncionarioId())
                .status(f.getStatus())
                .build();
    }

    public List<FuncionarioPendencia> listarFuncionariosComPendencias() {
        var pendentes = emprestimoRepository
                .findByStatusEmprestimoNot(StatusEmprestimo.FINALIZADO);
        var agrupado = pendentes.stream()
                .collect(Collectors.groupingBy(Emprestimo::getFuncionario));
        return agrupado.entrySet().stream().map(e -> {
            var func = get(e.getKey());
            var listaPend = e.getValue().stream()
                    .map(emp -> PendenciaStatus.builder()
                            .equipamentoId(emp.getEquipamento())
                            .statusEmprestimo(emp.getStatusEmprestimo())
                            .build())
                    .toList();
            return FuncionarioPendencia.builder()
                    .funcionarioId(func.getFuncionarioId())
                    .nome(func.getNome())
                    .pendencias(listaPend)
                    .build();
        }).toList();
    }

}
