package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorRegisterDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.AutorResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.AutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<ResponseDTO> post(@RequestBody AutorRegisterDTO autorRegisterDTO){
        try{
            autorService.addAutor(autorRegisterDTO);
            return new ResponseEntity<>(
                    new ResponseDTO(autorRegisterDTO.getName(),"Autor salvo com sucesso!"),
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
    public ResponseEntity<ResponseDTO> put(@RequestBody AutorDTO autorDTO){
        try{
            autorService.putAutor(autorDTO);
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

    @GetMapping("/autor")
    public ResponseEntity<List<AutorResponseDTO>> getAll(){
        List<AutorResponseDTO> autores = autorService.getAutores();
        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @GetMapping("/autor/{name}")
    public ResponseEntity<List<AutorResponseDTO>> getAutorByName(@PathVariable String name){
        List<AutorResponseDTO> autores = autorService.getAutorByName(name);

        if (autores == null || autores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(autores, HttpStatus.OK);
    }

    @DeleteMapping("/autor")
    public ResponseEntity<ResponseDTO> deleteAutor(@RequestBody AutorDTO autorDTO){
        try{
            autorService.deleteAutorByID(autorDTO.getAutorID());
            return new ResponseEntity<>(
                    new ResponseDTO(autorDTO.getName(), "Autor deletado com sucesso!"),HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(autorDTO.getName(), "Erro ao deletar autor: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
