package br.com.vivo.conciliacaoproducer.service;

import br.com.vivo.databasesdk.dto.TransacaoDTO;
import br.com.vivo.databasesdk.enums.TransactionStatus;
import br.com.vivo.databasesdk.model.Transacao;
import br.com.vivo.databasesdk.service.TransacaoService;
import br.com.vivo.databasesdk.util.ConvertObjectDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@ComponentScan(basePackages = {
        "br.com.vivo.databasesdk"
})
@Service
public class ConciliacaoProducerService {

    private final KafkaTemplate<String, List<TransacaoDTO>> kafkaTemplate;
    private static final String TOPIC = "conciliacoes";

    private final TransacaoService transacaoService;

    public ConciliacaoProducerService(KafkaTemplate<String, List<TransacaoDTO>> kafkaTemplate, TransacaoService transacaoService) {
        this.kafkaTemplate = kafkaTemplate;
        this.transacaoService = transacaoService;
    }

    public void produce() {
        System.out.println("findByTransactionStatus");
        List<Transacao> list = transacaoService.findByTransactionStatus(TransactionStatus.PENDING);
        List<TransacaoDTO> listDTO =
                list.stream()
                        .map(ConvertObjectDTO::convertTransacaoToDto).toList();
        System.out.println("send topic " + TOPIC);
        kafkaTemplate.send(TOPIC, listDTO);
        System.out.println("Transacoes produzidas com sucesso");
    }

}
