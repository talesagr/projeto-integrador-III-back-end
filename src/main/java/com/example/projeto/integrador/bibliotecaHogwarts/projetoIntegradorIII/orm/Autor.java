package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "autor")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autoroid")
    private Integer autoroid;

    private String name;
    @OneToMany(mappedBy = "autoroid", cascade = CascadeType.ALL)
    private List<AutorLivros> autorlivros;
    @OneToOne
    @JoinColumn(name = "pessoaoid")
    private Pessoa pessoa;


}
