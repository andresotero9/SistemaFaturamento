package br.com.vivo.transacaoconsumer.service;

import br.com.vivo.databasesdk.dto.TransacaoDTO;
import br.com.vivo.databasesdk.enums.TransactionStatus;
import br.com.vivo.databasesdk.model.Transacao;
import br.com.vivo.databasesdk.service.TransacaoService;
import br.com.vivo.databasesdk.util.ConvertObjectDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransacaoConsumerService {

    private final TransacaoService transacaoService;
    public TransacaoConsumerService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @KafkaListener(topics = "transacoes", groupId = "transacao-group")
    public void consumer(TransacaoDTO dto) {

        Transacao transacao = ConvertObjectDTO.convertDtoToTransacao(dto);

        transacao.setDataIntegracao(LocalDateTime.now());
        transacao.setTransactionStatus(TransactionStatus.PENDING);

        transacaoService.save(transacao);

        System.out.println("Transação salva: " + dto);
    }
}
