package br.com.sgee.gestaodeequipamentos.repository;


import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEquipamentoRepository extends JpaRepository<TipoEquipamento, Integer> {
}
