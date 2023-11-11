package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findByEmail(String email);
}
