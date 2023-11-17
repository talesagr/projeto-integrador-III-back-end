package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaResponseDTO {
    private Integer pessoaoid;
    private String nome;
    private Integer idade;
    private String cpf;
    private String endereco;
    private String celular;
    private UserType userType;
}
