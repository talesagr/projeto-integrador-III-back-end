package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends People{

    private String name;
    private String password;
    private String email;
    private UserType userType;
}
