package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro,Integer> {

    @Query("SELECT l FROM Livro l WHERE l.disponivel = true")
    Iterable<Livro> findAvailables();

    @Query("SELECT l FROM Livro l WHERE l.disponivel = false")
    Iterable<Livro> findNOTAvailables();
}
