package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.PessoaDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Pessoa;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public void addPessoa(Pessoa pessoa) throws Exception{
        try{
            Pessoa pessoaORM = new Pessoa();
            pessoaORM.setNome(pessoa.getNome());
            pessoaORM.setCpf(pessoa.getCpf());
            pessoaORM.setCelular(pessoa.getCelular());
            pessoaORM.setEndereco(pessoa.getEndereco());
            pessoaORM.setIdade(pessoa.getIdade());
            pessoaORM.setUserType(pessoa.getUserType());
            pessoaRepository.save(pessoaORM);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void updatePessoa(int id, PessoaDTO dados) throws Exception {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()){
            if(!dados.getNome().equals(pessoaOptional.get().getNome())){
                pessoaOptional.get().setNome(dados.getNome());
            }
            if(dados.getIdade() != pessoaOptional.get().getIdade()){
                pessoaOptional.get().setIdade(dados.getIdade());
            }
            if(dados.getEndereco() != pessoaOptional.get().getEndereco()){
                pessoaOptional.get().setEndereco(dados.getEndereco());
            }
            if(dados.getCpf() != pessoaOptional.get().getCelular()){
                pessoaOptional.get().setCpf(dados.getCpf());
            }
            if(dados.getCelular() != pessoaOptional.get().getCelular()){
                pessoaOptional.get().setCelular(dados.getCelular());
            }
            if(dados.getUserType() != pessoaOptional.get().getUserType()){
                pessoaOptional.get().setUserType(dados.getUserType());
            }
            pessoaRepository.save(pessoaOptional.get());
        } else {
            throw new Exception("Pessoa nao encontrada!");
        }
    }

    public List<Pessoa> getPessoas() {
        Iterable<Pessoa> iterable = pessoaRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
}