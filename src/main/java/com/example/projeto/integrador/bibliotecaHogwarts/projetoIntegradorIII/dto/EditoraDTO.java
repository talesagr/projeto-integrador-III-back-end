package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Editora;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EditoraDTO {
    private Integer id;

    private String descricao;

    public Editora toORM() {
        return new Editora(this.id,this.descricao);
    }
}
