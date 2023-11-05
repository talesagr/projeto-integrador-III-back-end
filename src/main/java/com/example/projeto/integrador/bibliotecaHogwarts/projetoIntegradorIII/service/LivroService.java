package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

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

    public List<Livro> getLivros() {
        Iterable<Livro> livroIterable = livroRepository.findAll();
        List<Livro> livros = new ArrayList<>();
        livroIterable.forEach(livros::add);
        return livros;
    }

    public void deleteLivroByID(Integer livrooid) {
        Optional<Livro> livroOptional = livroRepository.findById(livrooid);
        if(livroOptional.isPresent()){
            Livro livro = livroOptional.get();
            livroRepository.delete(livro);
        }
    }
}
