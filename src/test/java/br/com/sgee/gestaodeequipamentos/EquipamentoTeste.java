package br.com.sgee.gestaodeequipamentos;

import br.com.sgee.gestaodeequipamentos.model.Equipamento;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusEquipamento;
import br.com.sgee.gestaodeequipamentos.repository.EquipamentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class EquipamentoTeste {

    @Autowired
    private EquipamentoRepository repository;

    @Test
    void salvarEquipamento() {
        // Criação do equipamento
        Equipamento equipamento = Equipamento.builder()
                .nomeEquipamento("Televisao")
                .statusEquipamento(StatusEquipamento.DISPONIVEL)
                .build();

        // Salvando no repositório
        Equipamento equipamentoSalvo = repository.save(equipamento);

        // Verificação
        assertNotNull(equipamentoSalvo.getIdEquipamento(), "O ID do equipamento salvo não deve ser nulo");
    }
}