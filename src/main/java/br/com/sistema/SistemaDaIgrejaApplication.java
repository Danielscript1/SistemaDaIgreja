package br.com.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sistema.domain.Ata;
import br.com.sistema.domain.Igreja;
import br.com.sistema.repositories.AtaRepository;
import br.com.sistema.repositories.IgrejaRepository;

@SpringBootApplication
public class SistemaDaIgrejaApplication  {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaDaIgrejaApplication.class, args);
	}


}
