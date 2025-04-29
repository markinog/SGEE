package br.com.sgee.gestaodeequipamentos.repository;

import br.com.sgee.gestaodeequipamentos.model.Emprestimo;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    List<Emprestimo> findByStatusEmprestimoNot(StatusEmprestimo statusEmprestimo);
}
