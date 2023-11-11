package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.LoginRequestDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Usuario;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequestDTO loginRequest, HttpSession session) {
        String email = loginRequest.getEmail();
        String senha = loginRequest.getSenha();

        Usuario user = userRepository.findByEmail(email)
                .orElse(null);

        if (user != null && user.getSenha().equals(senha)) {
            session.setAttribute("email", email);
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }

}
