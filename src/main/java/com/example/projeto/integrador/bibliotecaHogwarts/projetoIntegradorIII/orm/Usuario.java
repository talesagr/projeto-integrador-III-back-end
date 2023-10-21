package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuariooid")
    private Integer usuariooid;

    @OneToOne
    @JoinColumn(name = "pessoaoid")
    private Pessoa pessoa;

    private String email;

    private String senha;

}
