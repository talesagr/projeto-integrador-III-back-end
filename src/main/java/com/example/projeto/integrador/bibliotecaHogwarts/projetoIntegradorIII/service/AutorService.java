package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Autor;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public void addAutor(AutorDTO autorDTO) {
            Autor autorORM = new Autor();
            autorORM.setName(autor.getName());
            autorORM.setAutoroid(autor.getAutoroid());
            autorORM.setLivros(autor.getLivros());
            autorORM.setPessoa(autor.getPessoa());
            autorRepository.save(autorORM);
    }

    public void putAutor(Autor toORM) throws Exception{
        Optional<Autor> autorOptional = autorRepository.findById(toORM.getAutoroid());

        if(autorOptional.isPresent()){
            Autor autor = autorOptional.get();
            if(!autor.getName().equals(toORM.getName()) && toORM.getName() != ""){
                autor.setName(toORM.getName());
            }
            if(!autor.getPessoa().equals(toORM.getPessoa()) && toORM.getPessoa() != null){
                autor.setPessoa(toORM.getPessoa());
            }
            if(!autor.getAutoroid().equals(toORM.getAutoroid()) && toORM.getAutoroid() != null){
                autor.setAutoroid(toORM.getAutoroid());
            }
            if(!autor.getLivros().equals(toORM.getLivros()) && toORM.getLivros() != null){
                autor.setLivros(toORM.getLivros());
            }
            autorRepository.save(toORM);
        } else {
            throw new Exception("Autor nao encontrado!");
        }

    }

    public List<Autor> getAutores() {
        Iterable<Autor> iterable = autorRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void deleteAutorByID(Integer id) throws Exception {
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isPresent()){
            autorRepository.deleteById(id);
        } else {
            throw new Exception("Autor nao encontrado!");
        }
    }
}
