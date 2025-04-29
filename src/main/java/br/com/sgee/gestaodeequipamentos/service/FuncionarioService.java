package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.dto.FuncionarioRequest;
import br.com.sgee.gestaodeequipamentos.dto.FuncionarioResponse;
import br.com.sgee.gestaodeequipamentos.mapper.FuncionarioMapper;
import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import br.com.sgee.gestaodeequipamentos.model.enums.FuncionarioStatus;
import br.com.sgee.gestaodeequipamentos.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

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


}
