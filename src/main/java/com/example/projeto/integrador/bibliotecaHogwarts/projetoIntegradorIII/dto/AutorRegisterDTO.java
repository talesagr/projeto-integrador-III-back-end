package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Livro;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorRegisterDTO {
    private Integer autorID;
    private String name;
    private Pessoa pessoa;
    @JsonIgnore
    private List<Livro> livros;

    public AutorDTO toAutorDTO() {
        List<LivroDTO> livroDTOs = livros.stream()
                .map(Livro::toLivroDTO)
                .collect(Collectors.toList());

        return new AutorDTO(autorID, name, livroDTOs, pessoa.getPessoaoid());
    }
}
