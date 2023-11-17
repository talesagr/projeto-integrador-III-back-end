package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "autor")
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autoroid")
    private Integer autoroid;

    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;
    @OneToOne
    @JoinColumn(name = "pessoaoid")
    private Pessoa pessoa;

    public Integer getAutoroid() {
        return autoroid;
    }

    public String getName() {
        return name;
    }
    @JsonManagedReference
    @JsonIgnore
    public List<Livro> getLivros() {
        return livros;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
