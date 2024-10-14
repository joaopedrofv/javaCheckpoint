package com.example.checkpoint.controller;

import com.example.checkpoint.dto.Auth;
import com.example.checkpoint.dto.Login;
import com.example.checkpoint.dto.Register;
import com.example.checkpoint.model.User;
import com.example.checkpoint.repository.UserRepository;
import com.example.checkpoint.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid Auth authDTO) {
        var userPass = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.senha());
        var auth = this.authenticationManager.authenticate(userPass);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new Login(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Register registerDTO) {
        if (userRepository.findByLogin(registerDTO.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.senha());
        User newUser = new User(registerDTO.login(), encryptedPassword, registerDTO.role());
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
