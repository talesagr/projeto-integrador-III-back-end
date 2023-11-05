package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "livro")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livrooid")
    private Integer livrooid;
    private String titulo;
    @ManyToOne
    @JoinColumn(name = "autoroid")
    private Autor autor;
    private int paginas;
    @OneToOne
    @JoinColumn(name = "editoraoid")
    private Editora editora;
    @OneToOne
    @JoinColumn(name = "generooid")
    private Genero genero;
}
