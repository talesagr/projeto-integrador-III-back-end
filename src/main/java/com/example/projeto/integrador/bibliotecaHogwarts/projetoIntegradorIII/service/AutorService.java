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
            autorORM.setAutorlivros(autor.getAutorlivros());
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
            if(!autor.getAutorlivros().equals(toORM.getAutorlivros()) && toORM.getAutorlivros() != null){
                autor.setAutorlivros(toORM.getAutorlivros());
            }
            autorRepository.save(toORM);
        } else {
            throw new Exception("Autor nao encontrado!");
        }

    }
}
