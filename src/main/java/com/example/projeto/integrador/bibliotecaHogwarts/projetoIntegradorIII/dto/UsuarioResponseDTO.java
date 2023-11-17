package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDTO {
    private Integer usuariooid;
    private PessoaResponseDTO pessoa;
    private String email;
    private String senha;
}
