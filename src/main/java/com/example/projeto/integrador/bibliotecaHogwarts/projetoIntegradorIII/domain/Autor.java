package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    private String name;
    private People personalData;
    private List<Livro> books = new ArrayList<>();

    public Autor(String name, List<Livro> books){
        this.name = name;
        this.books = books;
    }
}
