package br.com.vivo.transacaoconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
		"br.com.vivo.transacaoconsumer",
		"br.com.vivo.databasesdk"
})
@EnableJpaRepositories(basePackages = "br.com.vivo.databasesdk.repository")
@EntityScan(basePackages = "br.com.vivo.databasesdk.model")
public class ConciliacaoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConciliacaoServiceApplication.class, args);
	}

}
