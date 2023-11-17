package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.LivroDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "livro")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "livrooid")
    private Integer livrooid;
    private String titulo;
    @JsonManagedReference
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

    public LivroDTO toLivroDTO() {
        return new LivroDTO(livrooid, titulo, autor.getAutoroid(), paginas, editora.getEditoraoid(), genero.getGenerooid());
    }
}
