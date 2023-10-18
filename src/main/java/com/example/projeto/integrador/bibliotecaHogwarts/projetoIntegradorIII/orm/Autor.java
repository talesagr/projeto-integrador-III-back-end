package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "autor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer autoroid;

    private String name;
    private Integer autorlivrosoid;
    @OneToOne
    private Pessoa pessoaoid;


}
