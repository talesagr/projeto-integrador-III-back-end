package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Setter
@Getter
public class ResponseDTO {
    private String userID;
    private String resultMessage;
    private Map<String, Object> body;

    public ResponseDTO(String userID, String resultMessage) {
        this.userID = userID;
        this.resultMessage = resultMessage;
        this.body = Map.of();
    }
}
