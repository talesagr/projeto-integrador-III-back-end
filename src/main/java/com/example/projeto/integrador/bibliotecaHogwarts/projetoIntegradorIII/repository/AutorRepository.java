package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Autor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AutorRepository extends CrudRepository<Autor,Integer> {
    @Query("SELECT a FROM Autor a INNER JOIN a.pessoa p WHERE p.nome = :name")
    Iterable<Autor> findByName(@Param("name") String name);
}
