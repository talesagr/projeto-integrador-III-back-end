package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.GeneroRepository;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository){
        this.generoRepository = generoRepository;
    }

    public void addGenero(String genero) throws Exception {
        try {
            Genero generoORM = new Genero();
            generoORM.setDescricao(genero);
            generoRepository.save(generoORM);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
