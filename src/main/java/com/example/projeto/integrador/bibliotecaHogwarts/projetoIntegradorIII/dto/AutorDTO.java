package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Autor;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorDTO {
    private Integer autorID;
    private String name;
    private Integer autorLivrosOID;
    private Pessoa pessoaOID;

    public Autor toORM() {
        return new Autor(autorID,name,autorLivrosOID,pessoaOID);
    }

}
