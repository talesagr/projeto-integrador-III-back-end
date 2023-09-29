package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.EditoraDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Editora;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.EditoraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public void updateEditoraDesc(Integer id, EditoraDTO editoraDTO) throws Exception {
        Optional<Editora> editora = editoraRepository.findById(id);
        if (editora.isPresent()){
            Editora updatedEditora = editora.get();
            updatedEditora.setDescricao(editoraDTO.getDescricao());
            editoraRepository.save(updatedEditora);
        } else {
            throw new Exception("Editora nao encontrada");
        }
    }

    public void deleteEditoraByID(Integer id) throws Exception {
        Optional<Editora> editora = editoraRepository.findById(id);
        if (editora.isPresent()){
            editoraRepository.deleteById(id);
        } else {
            throw new Exception("Editora nao encontrada");
        }
    }

    public List<Editora> getEditoras() {
        Iterable<Editora> iterable = editoraRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}
