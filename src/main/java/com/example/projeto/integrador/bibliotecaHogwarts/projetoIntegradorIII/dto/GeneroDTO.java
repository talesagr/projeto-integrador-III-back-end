package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@Getter
@Setter
public class GeneroDTO {

    private Integer id;

    @NotEmpty
    private String genero;

    public Genero toORM() {
        return new Genero(this.id,this.genero);
    }

}
