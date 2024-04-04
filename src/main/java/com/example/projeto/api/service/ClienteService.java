package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.projeto.api.dto.ClienteDTO;
import com.example.projeto.api.dto.CreateClienteDTO;
import com.example.projeto.api.dto.UpdateClienteDTO;
import com.example.projeto.api.model.Cliente;
import com.example.projeto.api.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO cadastrar(CreateClienteDTO createDTO){
        Cliente cliente = new Cliente(createDTO.getNome(),createDTO.getEmail(),createDTO.getSenha(),createDTO.getCelular());
        cliente = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }

    @Transactional
    public ClienteDTO atualizar(UpdateClienteDTO updateDTO, String emailCliente){
        Cliente cliente = clienteRepository.findByEmail(emailCliente);
        cliente.setNome(updateDTO.getNome());
        cliente.setCelular(updateDTO.getCelular());
        cliente = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }

    @Transactional
    public void excluir(String emailCliente){
        Cliente cliente = clienteRepository.findByEmail(emailCliente);
        clienteRepository.deleteById(cliente.getId());
    }

    public ClienteDTO recuperar(String emailCliente){
        Cliente cliente = clienteRepository.findByEmail(emailCliente);
        ClienteDTO clienteDTO = new ClienteDTO(cliente);
        return clienteDTO;
    }
}
