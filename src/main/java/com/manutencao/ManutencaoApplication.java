package com.manutencao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API - Sistema para manutenção em geral.",
			version = "1.0",
			description = " API para um sistema de suporte para profissionais de serviços de pintura,elétrica e encanamento .",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class ManutencaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManutencaoApplication.class, args);
	}

}
