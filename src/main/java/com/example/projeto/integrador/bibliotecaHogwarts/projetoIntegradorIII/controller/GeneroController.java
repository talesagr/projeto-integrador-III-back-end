package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.GeneroDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.GeneroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            generoService.addGenero(genero.getGenero());
            return new ResponseEntity<>(
                    new ResponseDTO(genero.getGenero(),"Genero salvo com sucesso!"),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
