package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.GeneroDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.GeneroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService){
        this.generoService = generoService;
    }
    @PostMapping("/genero")
    public ResponseEntity<ResponseDTO> post(@RequestBody GeneroDTO genero){
        try {
            generoService.addGenero(genero.getDescricao());
            return new ResponseEntity<>(
                    new ResponseDTO(genero.getDescricao(),"Genero salvo com sucesso!"),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Genero>> getGeneros(){
        List<Genero> generos = generoService.getGeneros();
        return new ResponseEntity<>(generos, HttpStatus.OK);
    }

    @GetMapping("/genero/{desc}")
    public ResponseEntity<List<Genero>> getGeneros(@PathVariable String desc){
        List<Genero> generos = generoService.getgenerosByDesc(desc);
        return new ResponseEntity<>(generos, HttpStatus.OK);
    }

    @PutMapping("/genero")
    public ResponseEntity<ResponseDTO> put(@RequestBody GeneroDTO generoDTO){
        try {
            generoService.updateGeneroDesc(generoDTO.getId(),generoDTO);
            return new ResponseEntity<>(
                    new ResponseDTO(generoDTO.getDescricao(), "Genero atualizado com sucesso!"), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseDTO(generoDTO.getDescricao(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/genero")
    public ResponseEntity<ResponseDTO> delete(@RequestBody GeneroDTO generoDTO){
        try {
            generoService.deleteGeneroByID(generoDTO.getId());
            return new ResponseEntity<>(
                    new ResponseDTO(generoDTO.getDescricao(), "Genero deletado com sucesso!"),HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(generoDTO.getDescricao(), "Erro ao deletar genero: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
