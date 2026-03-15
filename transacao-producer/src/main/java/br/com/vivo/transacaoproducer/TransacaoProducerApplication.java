package br.com.vivo.transacaoproducer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TransacaoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransacaoProducerApplication.class, args);
    }

}
