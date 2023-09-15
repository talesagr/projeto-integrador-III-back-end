package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.People;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.User;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {
    private int idade;
    private String CPF;
    private String endereco;
    private String celular;
    private UserType userType;
    public People toDomain() {
        return new People(idade,CPF,endereco,celular,userType);
    }
}
