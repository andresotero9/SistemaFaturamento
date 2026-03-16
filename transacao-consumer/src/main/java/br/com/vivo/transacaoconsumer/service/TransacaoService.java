package br.com.vivo.transacaoconsumer.service;

import br.com.vivo.transacaoconsumer.dto.TransacaoDTO;
import br.com.vivo.transacaoconsumer.enums.TransactionStatus;
import br.com.vivo.transacaoconsumer.model.Transacao;
import br.com.vivo.transacaoconsumer.repository.TransacaoRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "transacoes", groupId = "transacao-group")
    public void consumer(TransacaoDTO dto) {

        Transacao transacao = new Transacao();
        transacao.setTransacaoCod(dto.transacaoCod());
        transacao.setValor(dto.valor());
        transacao.setDataTransacao(dto.dataTransacao());
        transacao.setDataProducer(dto.dataProducer());
        transacao.setDataIntegracao(LocalDateTime.now());
        transacao.setTransactionStatus(TransactionStatus.PENDING);

        transacaoRepository.save(transacao);

        System.out.println("Transação salva: " + dto);
    }

}
