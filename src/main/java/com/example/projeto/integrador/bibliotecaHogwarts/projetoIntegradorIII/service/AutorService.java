package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Autor;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Livro;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.AutorRepository;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
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
    private final PessoaRepository pessoaRepository;
    private final LivroService livroService;

    public void addAutor(AutorDTO autorDTO) {
        Autor autorORM = new Autor();
        autorORM.setName(autorDTO.getName());
        autorORM.setAutoroid(autorDTO.getAutorID());
        List<Livro> livrosORM = livroService.addLivrosByAutor(autorDTO);

        autorORM.setLivros(livrosORM);
        Pessoa pessoa = pessoaRepository.findById(autorDTO.getPessoaoid())
                        .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
        autorORM.setPessoa(pessoa);
        autorRepository.save(autorORM);
    }


    public void putAutor(AutorDTO autorDTO) throws Exception{
        Optional<Autor> autorOptional = autorRepository.findById(autorDTO.getAutorID());

        if(autorOptional.isPresent()){
            Autor autor = autorOptional.get();
            if(!autor.getName().equals(autorDTO.getName()) && autorDTO.getName() != ""){
                autor.setName(autorDTO.getName());
            }
            if(!autor.getPessoa().getPessoaoid().equals(autorDTO.getPessoaoid()) && autorDTO.getPessoaoid() != null){
                Pessoa pessoa = pessoaRepository.findById(autorDTO.getPessoaoid())
                                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada"));
                autor.setPessoa(pessoa);
            }
            if(!autor.getAutoroid().equals(autorDTO.getAutorID()) && autorDTO.getAutorID() != null){
                autor.setAutoroid(autorDTO.getAutorID());
            }
            if(!autor.getLivros().equals(autorDTO.getLivros()) && autorDTO.getLivros() != null){
                List<Livro> livrosORM = livroService.addLivrosByAutor(autorDTO);
                autor.setLivros(livrosORM);
            }
            autorRepository.save(autor);
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
