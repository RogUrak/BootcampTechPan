package com.igti.aulainterativadois;

import com.igti.aulainterativadois.entities.Pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulainterativadoisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulainterativadoisApplication.class, args);
    Pessoa p = new Pessoa();
    p.setNome("Joao");
    System.out.println(p);
	}

}
