package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    private Autor autor;
    private String titulo;
    private Genero genero;
    private int paginas;
    private Editora editora;
}
