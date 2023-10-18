package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.AutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    @PostMapping("/autor")
    public ResponseEntity<ResponseDTO> post(AutorDTO autorDTO){
        try{
            autorService.addAutor(autorDTO.toORM());
            return new ResponseEntity<>(
                    new ResponseDTO(autorDTO.getName(),"Autor salvo com sucesso!"),
                    HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/autor")
    public ResponseEntity<ResponseDTO> put(AutorDTO autorDTO){
        try{
            autorService.putAutor(autorDTO.toORM());
            return new ResponseEntity<>(
                    new ResponseDTO(autorDTO.getName(),"Autor atualizado com sucesso!"),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
