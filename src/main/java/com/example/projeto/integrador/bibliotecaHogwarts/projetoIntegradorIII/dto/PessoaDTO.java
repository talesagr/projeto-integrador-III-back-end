package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
    private Integer id;
    private String nome;
    private Integer idade;
    private String cpf;
    private String endereco;
    private String celular;
    private UserType userType;

    public Pessoa toORM() {
        return new Pessoa(id,nome,idade,cpf,endereco,celular,userType);
    }
}
