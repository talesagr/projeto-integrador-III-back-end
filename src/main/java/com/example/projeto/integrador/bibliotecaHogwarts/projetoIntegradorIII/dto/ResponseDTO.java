package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
public class ResponseDTO {
    private String ID;
    private String resultMessage;
    private Map<String, Object> body;

    public ResponseDTO(String savedID, String resultMessage) {
        this.ID = savedID;
        this.resultMessage = resultMessage;
        this.body = Map.of();
    }
}
