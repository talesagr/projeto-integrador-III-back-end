package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {
    private Integer livrooid;
    private String titulo;
    private Integer autoroid;
    private int paginas;
    private Integer editoraoid;
    private Integer generooid;

}
