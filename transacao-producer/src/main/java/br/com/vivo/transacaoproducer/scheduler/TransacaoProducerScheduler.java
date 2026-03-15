package br.com.vivo.transacaoproducer.scheduler;

import br.com.vivo.transacaoproducer.service.TransacaoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TransacaoProducerScheduler {

    private final TransacaoService transacaoService;

    public TransacaoProducerScheduler(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @Scheduled(fixedRate = 1000 * 5)
    public void scheduler() {
        transacaoService.produce();
    }


}
