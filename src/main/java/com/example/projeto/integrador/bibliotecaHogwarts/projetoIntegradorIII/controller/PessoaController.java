package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.PessoaDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@AllArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;
    @PostMapping("/pessoa")
    ResponseEntity<ResponseDTO> post(@RequestBody PessoaDTO pessoaDTO){
        try{
            pessoaService.addPessoa(pessoaDTO.toORM());
            return new ResponseEntity<>(
                    new ResponseDTO(pessoaDTO.getNome(),"Pessoa salva com sucesso!"),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @PutMapping("/pessoa")
    ResponseEntity<ResponseDTO> put(@RequestBody PessoaDTO pessoaDTO){
        try{
            pessoaService.updatePessoa(pessoaDTO.getId(),pessoaDTO);
            return new ResponseEntity<>(
                    new ResponseDTO(pessoaDTO.getNome(),"Pessoa salva com sucesso!"),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> getPessoas(){
        List<Pessoa> pessoas = pessoaService.getPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @GetMapping("/pessoa/ultimoID")
    public ResponseEntity<Integer> getLastID(){
        int lastID = pessoaService.getPessoas().size();
        return new ResponseEntity<>(lastID, HttpStatus.OK);
    }


}
