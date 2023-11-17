package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoa")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    public Pessoa(String nome, Integer idade, String cpf, String endereco, String celular, UserType userType) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
        this.celular = celular;
        this.userType = userType;
    }
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
