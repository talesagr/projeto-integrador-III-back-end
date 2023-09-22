package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.GeneroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoIntegradorIiiApplication implements CommandLineRunner {

	private final GeneroRepository repository;
	public ProjetoIntegradorIiiApplication(GeneroRepository repository){
		this.repository = repository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProjetoIntegradorIiiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Genero genero = new Genero();
		genero.setDescricao("CLASSICOS");
		repository.save(genero);
	}
}
