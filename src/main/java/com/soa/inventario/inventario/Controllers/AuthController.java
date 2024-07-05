package com.soa.inventario.inventario.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soa.inventario.inventario.Entities.Credenciales;
import com.soa.inventario.inventario.Entities.User;
import com.soa.inventario.inventario.Repositories.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Credenciales credenciales) {

        Optional<User> userLogin = userRepository.findByUsername(credenciales.getUsername());
        System.out.println(credenciales.getUsername());

        if(userLogin.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userLogin.get());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user ) {

        User savedUser = userRepository.save(user);
        System.out.println(savedUser.getUsername());
        return ResponseEntity.ok(savedUser);
    }

    

}
