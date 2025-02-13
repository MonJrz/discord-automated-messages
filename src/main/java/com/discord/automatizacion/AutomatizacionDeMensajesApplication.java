package com.discord.automatizacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutomatizacionDeMensajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatizacionDeMensajesApplication.class, args);
	}

}
