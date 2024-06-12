package com.example.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.AuthenticationDTO;
import com.example.projeto.api.dto.LoginResponseDTO;
import com.example.projeto.api.model.Usuario;
import com.example.projeto.api.service.TokenService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    private ResponseEntity login(@RequestBody AuthenticationDTO dto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario)auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
