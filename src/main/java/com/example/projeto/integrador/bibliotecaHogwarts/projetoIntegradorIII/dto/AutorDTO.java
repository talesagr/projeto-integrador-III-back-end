package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
    private Integer autorID;
    private String name;
    private List<LivroDTO> livros;
    private Integer pessoaoid;


}
