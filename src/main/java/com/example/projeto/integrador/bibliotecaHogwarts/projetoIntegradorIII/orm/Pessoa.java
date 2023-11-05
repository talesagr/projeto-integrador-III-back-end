package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoa")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pessoaoid;

    private String nome;
    private Integer idade;
    private String cpf;
    private String endereco;
    private String celular;
    private UserType userType;


}
