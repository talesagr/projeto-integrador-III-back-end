package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.domain.User;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.PeopleDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.UserDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class UserController {

    private UserService userService;

//    @PostMapping("/user")
//    public ResponseEntity<ResponseDTO> post(@RequestBody UserDTO userDTO){
//        try {
//            User userResult = this.userService.save(userDTO.toDomain());
//            return new ResponseEntity<>(
//                    new ResponseDTO(userResult.getName(), "usuário adicionado"),
//                    HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>(
//                    new ResponseDTO(null, ex.getMessage()),
//                    HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }

//    @PutMapping("/user/{userID}/detail/")
//    public ResponseEntity<ResponseDTO> put(@PathVariable Integer userID,@RequestBody PeopleDTO peopleDTO){
//        Optional<User> user = this.userService.findUserByID(userID);
//        if(user.isPresent()){
//            this.userService.putDetail(user.get(),peopleDTO);
//            return new ResponseEntity<>(new ResponseDTO(userID.toString(), "Success!"),HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ResponseDTO(null,"User not found!"),HttpStatus.NOT_FOUND);
//    }


}

