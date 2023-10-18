package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {
}
