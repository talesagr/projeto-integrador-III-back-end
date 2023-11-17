package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuario")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuariooid")
    private Integer usuariooid;

    @OneToOne
    @JoinColumn(name = "pessoaoid")
    @ToString.Exclude
    private Pessoa pessoa;

    private String email;

    private String senha;
}
