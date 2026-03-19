package br.com.vivo.conciliacaoproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {
        "br.com.vivo.transacaoconsumer",
        "br.com.vivo.databasesdk"
})
@EnableJpaRepositories(basePackages = "br.com.vivo.databasesdk.repository")
@EnableScheduling
@SpringBootApplication
public class ConciliacaoProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConciliacaoProducerApplication.class, args);
    }

}
