package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AutorResponseDTO {
    private Integer autorID;
    private String name;
    private List<LivroDTO> livros;
}
