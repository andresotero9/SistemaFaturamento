package br.com.vivo.transacaoproducer.service;

import br.com.vivo.transacaoproducer.dto.TransacaoDTO;
import br.com.vivo.transacaoproducer.util.TransacaoUtil;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    private final KafkaTemplate<String, TransacaoDTO> kafkaTemplate;
    private static final String TOPIC = "transacoes";

    public TransacaoService(KafkaTemplate<String, TransacaoDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce() {
        TransacaoDTO transacaoDTO = TransacaoUtil.gerarTransacaoFake();
        kafkaTemplate.send(TOPIC, transacaoDTO.transacaoCod(), transacaoDTO);
        System.out.println("Transacao produzida:" + transacaoDTO);
    }

}
