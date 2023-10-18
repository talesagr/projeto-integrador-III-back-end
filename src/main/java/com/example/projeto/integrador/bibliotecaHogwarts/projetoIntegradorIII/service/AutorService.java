package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Autor;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.AutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AutorService {
    private final AutorRepository autorRepository;

    public void addAutor(Autor autor) {
            Autor autorORM = new Autor();
            autorORM.setName(autor.getName());
            autorORM.setAutoroid(autor.getAutoroid());
            autorORM.setAutorlivrosoid(autor.getAutorlivrosoid());
            autorORM.setPessoaoid(autor.getPessoaoid());
            autorRepository.save(autorORM);
    }

    public void putAutor(Autor toORM) throws Exception{
        Optional<Autor> autorOptional = autorRepository.findById(toORM.getAutoroid());

        if(autorOptional.isPresent()){
            Autor autor = autorOptional.get();
            if(!autor.getName().equals(toORM.getName()) && toORM.getName() != ""){
                autor.setName(toORM.getName());
            }
            if(!autor.getPessoaoid().equals(toORM.getPessoaoid()) && toORM.getPessoaoid() != null){
                autor.setPessoaoid(toORM.getPessoaoid());
            }
            if(!autor.getAutoroid().equals(toORM.getAutoroid()) && toORM.getAutoroid() != null){
                autor.setAutoroid(toORM.getAutoroid());
            }
            if(!autor.getAutorlivrosoid().equals(toORM.getAutorlivrosoid()) && toORM.getAutorlivrosoid() != null){
                autor.setAutorlivrosoid(toORM.getAutorlivrosoid());
            }
            autorRepository.save(toORM);
        } else {
            throw new Exception("Autor nao encontrado!");
        }

    }
}
