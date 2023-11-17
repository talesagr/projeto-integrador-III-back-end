package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Editora;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EditoraRepository extends CrudRepository<Editora, Integer> {

    @Query("SELECT a FROM Editora a WHERE a.descricao = :desc")
    Iterable<Editora> findByDesc(@Param("desc") String desc);

}
