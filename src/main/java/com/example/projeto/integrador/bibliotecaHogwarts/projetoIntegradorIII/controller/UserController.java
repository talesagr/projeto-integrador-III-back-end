package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.*;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Usuario;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.UsuarioService;
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
public class UserController {

    private final UsuarioService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> post(@RequestBody UserDTO userDTO){
        try {
            Usuario userResult = this.userService.save(userDTO.toORM());
            UsuarioResponseDTO userResponseDTO = convertToDTO(userResult);
            return new ResponseEntity<>(
                    new ResponseDTO(userResponseDTO.getPessoa().getNome(), "usuário adicionado"),
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(
                    new ResponseDTO(null, ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/cliente")
    public ResponseEntity<List<Usuario>> getAllClienteUsers(){
        try {
            List<Usuario> usuarioList = this.userService.getAllClientes();
            return new ResponseEntity<>(usuarioList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/atendente")
    public ResponseEntity<List<Usuario>> getAllAtendenteUsers(){
        try {
            List<Usuario> usuarioList = this.userService.getAllAtendentes();
            return new ResponseEntity<>(usuarioList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private UsuarioResponseDTO convertToDTO(Usuario usuario) {
        PessoaResponseDTO pessoaDTO = new PessoaResponseDTO();
        pessoaDTO.setPessoaoid(usuario.getPessoa().getPessoaoid());

        UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO();
        usuarioDTO.setUsuariooid(usuario.getUsuariooid());
        usuarioDTO.setPessoa(pessoaDTO);
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setSenha(usuario.getSenha());

        return usuarioDTO;
    }
}

