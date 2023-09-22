package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Editora;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.EditoraRepository;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

    private final EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository){
        this.editoraRepository = editoraRepository;
    }

    public void addEditora(String editora) throws Exception {
        try {
            Editora editoraORM = new Editora();
            editoraORM.setDescricao(editora);
            editoraRepository.save(editoraORM);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
