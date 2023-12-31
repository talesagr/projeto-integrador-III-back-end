package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.UserType;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.UserTypeDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Usuario;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UsuarioService {

    private UserRepository userRepository;
    private PessoaService pessoaService;

    public Usuario save(Usuario newUser) throws Exception {
        Optional<Usuario> existingUser = userRepository.findByEmail(newUser.getEmail());

        if (existingUser.isPresent()) {
            throw new Exception("Usuário já existe");
        }

        Pessoa pessoa = newUser.getPessoa();
        if (pessoa != null && pessoa.getPessoaoid() == null) {
            Pessoa novaPessoa = new Pessoa(
                    pessoa.getNome(),
                    pessoa.getIdade(),
                    pessoa.getCpf(),
                    pessoa.getEndereco(),
                    pessoa.getCelular(),
                    pessoa.getUserType()
            );

            Pessoa pessoaSalva = pessoaService.addPessoa(novaPessoa);
            newUser.setPessoa(pessoaSalva);
        }

        Usuario newSavedUser = userRepository.save(newUser);

        return newSavedUser;
    }


    public List<Usuario> getAllUsersByType(UserTypeDTO userTypeDTO) {
        return this.userRepository.findAllByUserType(userTypeDTO.getUserType());
    }

    public List<Usuario> getAllClientes() {
        return this.userRepository.findAllByUserType(UserType.CLIENTE);
    }

    public List<Usuario> getAllAtendentes() {
        return this.userRepository.findAllByUserType(UserType.ATENDENTE);
    }
}
