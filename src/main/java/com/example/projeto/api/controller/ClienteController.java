package com.example.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.ClienteDTO;
import com.example.projeto.api.dto.CreateClienteDTO;
import com.example.projeto.api.dto.UpdateClienteDTO;
import com.example.projeto.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente/cadastro")
    public ClienteDTO cadastrarCliente(@RequestBody CreateClienteDTO dto) {
        return clienteService.cadastrar(dto);
    }

    @PutMapping("/cliente/atualizar")
    public ClienteDTO atualizarCliente(@RequestBody UpdateClienteDTO dto){
        return clienteService.atualizar(dto);
    }

    @DeleteMapping("/cliente/excluir/{id}")
    public ResponseEntity<?> excluirCliente(@PathVariable int id){
        clienteService.excluir(id);
        return ResponseEntity.ok().body("Conta excluída!");
    }

    @GetMapping("/cliente/recuperar/{id}")
    public ClienteDTO recuperarCliente(@PathVariable int id) {
        return clienteService.recuperar(id);
    }
    
}
