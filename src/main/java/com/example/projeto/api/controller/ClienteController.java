package com.example.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.ClienteDTO;
import com.example.projeto.api.dto.CreateClienteDTO;
import com.example.projeto.api.dto.UpdateClienteDTO;
import com.example.projeto.api.security.ClienteUserDetails;
import com.example.projeto.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente/cadastro")
    public ResponseEntity<String> cadastrarCliente(@RequestBody CreateClienteDTO dto) {
        clienteService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso!");
    }

    @PutMapping("/cliente/atualizar")
    public ResponseEntity<?> atualizarCliente(@RequestBody UpdateClienteDTO dto,
     @AuthenticationPrincipal ClienteUserDetails clienteAutenticado ){
        clienteService.atualizar(dto,clienteAutenticado.getUsername());
        return ResponseEntity.status(HttpStatus.OK).body("Seus dados foram atualizados!");
    }

    @DeleteMapping("/cliente/excluir")
    public ResponseEntity<?> excluirCliente(@AuthenticationPrincipal ClienteUserDetails clienteAutenticado){
        clienteService.excluir(clienteAutenticado.getUsername());
        return ResponseEntity.ok().body("Conta excluída!");
    }

    @GetMapping("/cliente/recuperar")
    public ClienteDTO recuperarCliente(@AuthenticationPrincipal ClienteUserDetails clienteAutenticado) {
        return clienteService.recuperar(clienteAutenticado.getUsername());
    }
    
}
