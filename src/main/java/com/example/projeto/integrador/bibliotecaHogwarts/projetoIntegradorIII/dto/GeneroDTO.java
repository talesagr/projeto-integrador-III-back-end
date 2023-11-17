package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GeneroDTO {

    private Integer id;

    private String descricao;

    public Genero toORM() {
        return new Genero(this.id,this.descricao);
    }

}
