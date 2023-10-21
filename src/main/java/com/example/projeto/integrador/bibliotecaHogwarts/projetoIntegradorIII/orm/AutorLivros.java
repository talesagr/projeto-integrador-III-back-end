package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "autorlivros")
@Entity
@Getter
@Setter
public class AutorLivros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autorlivrosoid")
    private Integer autorlivrosoid;

    @ManyToOne
    @JoinColumn(name = "autoroid")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "livrooid")
    private Livro livro;
}
