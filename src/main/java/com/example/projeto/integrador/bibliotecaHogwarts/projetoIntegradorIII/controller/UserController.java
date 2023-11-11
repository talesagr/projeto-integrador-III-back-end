package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.UserDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Usuario;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api")
public class UserController {

    private final UsuarioService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseDTO> post(@RequestBody UserDTO userDTO){
        try {
            Usuario userResult = this.userService.save(userDTO.toORM());
            return new ResponseEntity<>(
                    new ResponseDTO(userResult.getPessoa().getNome(), "usuário adicionado"),
                    HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(
                    new ResponseDTO(null, ex.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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

