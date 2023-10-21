package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "livro")
@Entity
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livrooid")
    private Integer livrooid;
    private String titulo;
    @OneToMany(mappedBy = "livro")
    private List<AutorLivros> autorLivros;
    private int paginas;
    @OneToOne
    @JoinColumn(name = "editoraoid")
    private Editora editora;
    @OneToOne
    @JoinColumn(name = "generooid")
    private Genero genero;
}
