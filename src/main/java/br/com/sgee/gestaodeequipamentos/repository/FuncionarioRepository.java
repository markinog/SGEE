package br.com.sgee.gestaodeequipamentos.repository;

import br.com.sgee.gestaodeequipamentos.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
