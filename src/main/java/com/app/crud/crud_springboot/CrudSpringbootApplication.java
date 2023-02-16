package com.app.crud.crud_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.crud.crud_springboot.repositorio.UsuarioRepositorio;

@SpringBootApplication
public class CrudSpringbootApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootApplication.class, args);
	}

	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		// Usuario usuario1 = new Usuario("André", "andre191", "andrelmf555@gmail.com");
		// repositorio.save(usuario1);
	}

}
