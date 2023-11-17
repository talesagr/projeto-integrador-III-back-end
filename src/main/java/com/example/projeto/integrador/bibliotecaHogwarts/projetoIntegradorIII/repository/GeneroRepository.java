package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface GeneroRepository extends CrudRepository<Genero,Integer> {

    @Query("SELECT g FROM Genero g WHERE g.descricao = :desc")
    Iterable<Genero> findByDesc(@Param("desc") String desc);
}
