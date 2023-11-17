package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.GeneroDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public void updateGeneroDesc(Integer generoID, GeneroDTO generoDTO) throws Exception{
            Optional<Genero> genero = generoRepository.findById(generoID);
            if (genero.isPresent()){
                Genero updatedGenero = genero.get();
                updatedGenero.setDescricao(generoDTO.getDescricao());
                generoRepository.save(updatedGenero);
            } else {
                throw new Exception("GeneroOID nao existe");
            }
    }

    public void deleteGeneroByID(Integer id) throws Exception {
        Optional<Genero> genero = generoRepository.findById(id);
        if (genero.isPresent()){
            Genero deletedGenero = genero.get();
            generoRepository.deleteById(deletedGenero.getGenerooid());
        } else {
            throw new Exception("GeneroOID nao existe");
        }
    }

    public List<Genero> getGeneros() {
        Iterable<Genero> iterable = generoRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Genero> getgenerosByDesc(String desc) {
        Iterable<Genero> iterable = generoRepository.findByDesc(desc);
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
