package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.LivroDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Autor;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Editora;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Livro;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.AutorRepository;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.EditoraRepository;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.GeneroRepository;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LivroService {
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private EditoraRepository editoraRepository;
    private GeneroRepository generoRepository;

    public Livro addLivro(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setTitulo(livroDTO.getTitulo());
        livro.setPaginas(livroDTO.getPaginas());

        Autor autor = autorRepository.findById(livroDTO.getAutoroid())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));

        Editora editora = editoraRepository.findById(livroDTO.getEditoraoid())
                .orElseThrow(() -> new EntityNotFoundException("Editora não encontrada"));

        Genero genero = generoRepository.findById(livroDTO.getGenerooid())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado"));

        livro.setAutor(autor);
        livro.setEditora(editora);
        livro.setGenero(genero);
        return livroRepository.save(livro);
    }

    public void putLivro(Integer livroId, LivroDTO livroDTO) {
        Livro livroExistente = livroRepository.findById(livroId)
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));

        livroExistente.setTitulo(livroDTO.getTitulo());
        livroExistente.setPaginas(livroDTO.getPaginas());

        Autor autor = autorRepository.findById(livroDTO.getAutoroid())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado"));
        livroExistente.setAutor(autor);

        Editora editora = editoraRepository.findById(livroDTO.getEditoraoid())
                .orElseThrow(() -> new EntityNotFoundException("Editora não encontrada"));
        livroExistente.setEditora(editora);

        Genero genero = generoRepository.findById(livroDTO.getGenerooid())
                .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado"));
        livroExistente.setGenero(genero);

        livroRepository.save(livroExistente);
    }

    public List<LivroDTO> getLivros() {
        Iterable<Livro> livroIterable = livroRepository.findAll();
        List<LivroDTO> livros = new ArrayList<>();
        livroIterable.forEach(livro -> livros.add(livro.toLivroDTO()));
        return livros;
    }

    public void deleteLivroByID(Integer livrooid) {
        Optional<Livro> livroOptional = livroRepository.findById(livrooid);
        if(livroOptional.isPresent()){
            Livro livro = livroOptional.get();
            livroRepository.delete(livro);
        }
    }


    public List<Livro> addLivrosByAutor(AutorDTO autorDTO) {
        List<Livro> livrosORM = new ArrayList<>();

        if (autorDTO.getLivros() != null) {
            for (LivroDTO livroDTO : autorDTO.getLivros()) {
                Livro livro = livroRepository.findById(livroDTO.getLivrooid()).orElse(null);

                if (livro == null) {
                    livro = new Livro();
                    livro.setTitulo(livroDTO.getTitulo());
                    livro.setPaginas(livroDTO.getPaginas());

                    Editora editora = editoraRepository.findById(livroDTO.getEditoraoid())
                            .orElseThrow(() -> new EntityNotFoundException("Editora não encontrada"));
                    livro.setEditora(editora);

                    Genero genero = generoRepository.findById(livroDTO.getGenerooid())
                            .orElseThrow(() -> new EntityNotFoundException("Gênero não encontrado"));
                    livro.setGenero(genero);

                    livroRepository.save(livro);
                }

                livrosORM.add(livro);
            }
        }
        return livrosORM;
    }

    public List<LivroDTO> getAvailableLivros() {
        Iterable<Livro> livroIterable = livroRepository.findAvailables();
        List<LivroDTO> livros = new ArrayList<>();
        livroIterable.forEach(livro -> livros.add(livro.toLivroDTO()));
        return livros;
    }

    public List<LivroDTO> getAllNOTAvailable() {
        Iterable<Livro> livroIterable = livroRepository.findNOTAvailables();
        List<LivroDTO> livros = new ArrayList<>();
        livroIterable.forEach(livro -> livros.add(livro.toLivroDTO()));
        return livros;
    }

    public void retirar(int livrooid){
        Optional<Livro> livro = livroRepository.findById(livrooid);
        if(livro.isPresent()){
            livro.get().setDisponivel(false);
            livroRepository.save(livro.get());
        }
    }

    public void devolver(int livrooid){
        Optional<Livro> livro = livroRepository.findById(livrooid);
        if(livro.isPresent()){
            livro.get().setDisponivel(true);
            livroRepository.save(livro.get());
        }
    }
}
