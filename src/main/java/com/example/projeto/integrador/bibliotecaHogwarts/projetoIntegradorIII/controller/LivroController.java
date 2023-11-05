package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.LivroDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Livro;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.LivroService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
public class LivroController {

    private final LivroService livroService;

    @PostMapping("/livro")
    public ResponseEntity<ResponseDTO> post(@RequestBody LivroDTO livroDTO){
        try{
            Livro livro = livroService.addLivro(livroDTO);
            return new ResponseEntity<>(
                    new ResponseDTO(livro.getTitulo(),"Livro salvo com sucesso!"),
                    HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/livro")
    public ResponseEntity<ResponseDTO> put(@RequestBody LivroDTO livroDTO){
        try{
            livroService.putLivro(livroDTO.getLivrooid(),livroDTO);
            return new ResponseEntity<>(
                    new ResponseDTO(livroDTO.getTitulo(),"Livro atualizado com sucesso!"),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/livro")
    public ResponseEntity<List<Livro>> getAll(){
        List<Livro> livros = livroService.getLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @DeleteMapping("/livro")
    public ResponseEntity<ResponseDTO> deleteLivro(@RequestBody LivroDTO livroDTO){
        try{
            livroService.deleteLivroByID(livroDTO.getLivrooid());
            return new ResponseEntity<>(
                    new ResponseDTO(livroDTO.getTitulo(), "Livro deletado com sucesso!"),HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(livroDTO.getTitulo(), "Erro ao deletar livro: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
