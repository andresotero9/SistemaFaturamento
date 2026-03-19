package br.com.vivo.conciliacaoproducer.scheduler;

import br.com.vivo.conciliacaoproducer.service.ConciliacaoProducerService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConciliacaoProducerScheduler {

    private final ConciliacaoProducerService service;

    public ConciliacaoProducerScheduler(ConciliacaoProducerService service) {
        this.service = service;
    }

    @Scheduled(fixedRate = 1000 * 60)
    public void scheduler() {
        this.service.produce();
    }

}
