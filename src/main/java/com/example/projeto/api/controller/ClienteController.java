package com.example.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.model.Cliente;
import com.example.projeto.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro/cliente")
    public ResponseEntity<String> cadastrar(@RequestBody Cliente cliente) {
        clienteService.cadastrar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso!");
    }
    
}
