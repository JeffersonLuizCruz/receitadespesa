package com.financial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.financial.entity")
@EnableJpaRepositories("com.financial.entity")
@ComponentScan({"com.financial.repository", "com.financial.repository.entry", "com.financial.repository.filter",
	"com.financial.repository.projection"})
public class ApiResTfulReceitaDespesaApplication{

	public static void main(String[] args) {
		SpringApplication.run(ApiResTfulReceitaDespesaApplication.class, args);
	}

}
