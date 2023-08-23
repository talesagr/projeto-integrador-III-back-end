package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String nome;
    private int idade;
    private String CPF;
    private String endereco;
    private String celular;
}
