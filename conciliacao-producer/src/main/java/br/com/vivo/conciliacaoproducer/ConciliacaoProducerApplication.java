package br.com.vivo.conciliacaoproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.vivo.databasesdk.repository")
@EnableScheduling
public class ConciliacaoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConciliacaoProducerApplication.class, args);
    }

}
