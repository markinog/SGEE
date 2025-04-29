package br.com.sgee.gestaodeequipamentos.repository;


import br.com.sgee.gestaodeequipamentos.model.TipoEquipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoEquipamentoRepository extends JpaRepository<TipoEquipamento, Integer> {
}
