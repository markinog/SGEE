package br.com.sgee.gestaodeequipamentos.service;

import br.com.sgee.gestaodeequipamentos.model.Emprestimo;
import br.com.sgee.gestaodeequipamentos.model.SolicitacaoCompra;
import br.com.sgee.gestaodeequipamentos.model.enums.StatusSolicitacaoCompra;
import br.com.sgee.gestaodeequipamentos.repository.SolicitacaoCompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SolicitacaoCompraService {

    private final SolicitacaoCompraRepository solicitacaoCompraRepository;

    public SolicitacaoCompra abrirSolicitacaoCompra(String nomeEquipamento, Integer quantidade, Emprestimo emprestimo){
        SolicitacaoCompra solicitacao = SolicitacaoCompra.builder()
                .nomeEquipamentoSolicitado(nomeEquipamento)
                .quantidadeSolicitada(quantidade)
                .statusSolicitacao(StatusSolicitacaoCompra.PENDENDTE)
                .dataSolicitacao(LocalDateTime.now())
                .emprestimoRelacionado(emprestimo).build();

        return solicitacaoCompraRepository.save(solicitacao);
    }

    public SolicitacaoCompra concluirSolcitacaoCompra(Integer solicitacaoId){
        SolicitacaoCompra solicitacao = solicitacaoCompraRepository.findById(solicitacaoId)
                .orElseThrow(() -> new RuntimeException("Solicitação de compra não encontrada"));

        solicitacao.setStatusSolicitacao(StatusSolicitacaoCompra.CONCLUIDA);
        solicitacao.setDataConclusao(LocalDateTime.now());

        return solicitacaoCompraRepository.save(solicitacao);
    }

}
