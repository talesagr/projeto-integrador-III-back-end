package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Usuario;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private UserRepository userRepository;
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
    public Usuario save(Usuario newUser) throws Exception {
/*
        Optional<User> user = this.userRepository.findByEmail(newUser.getEmail());

        if (user.isPresent()) {
            throw new Exception("usuário já existe");
        }
        newUser.setPassword(this.encodePassword(newUser.getPassword()));
        User newSavedUser = this.userRepository.save(newUser);

        return newSavedUser;
*/
        return null;
    }

  //  private String encodePassword(String password) {
   //     int strength = 10; // work factor of bcrypt
    //    BCryptPasswordEncoder bCryptPasswordEncoder =
    //            new BCryptPasswordEncoder(strength, new SecureRandom());
     //   String encodedPassword = "{bcrypt}" + bCryptPasswordEncoder.encode(password);
     //   return encodedPassword;


//    public Optional<User> findUserByID(Integer userID){
//        return this.userRepository.findById(userID);
//    }

}
