package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projeto.api.model.Cliente;
import com.example.projeto.api.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}
