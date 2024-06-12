package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.projeto.api.dto.ClienteDTO;
import com.example.projeto.api.dto.CreateClienteDTO;
import com.example.projeto.api.model.Cliente;
import com.example.projeto.api.model.Role;
import com.example.projeto.api.model.Usuario;
import com.example.projeto.api.model.EnumRole;
import com.example.projeto.api.repository.ClienteRepository;
import com.example.projeto.api.repository.UsuarioRepository;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public ResponseEntity<?> cadastrar(CreateClienteDTO dto){
        Usuario usuario = new Usuario(dto.getEmail(), dto.getSenha());
        Role role = new Role(EnumRole.CLIENTE);
        usuario.getRoles().add(role);
        usuario = usuarioRepository.save(usuario);
        Cliente cliente = new Cliente(dto.getNome(), dto.getCelular(), usuario);
        clienteRepository.save(cliente);

        return ResponseEntity.ok().body("cliente cadastrado!");
        
    }

    public ClienteDTO recuperar(String email){
        Cliente cliente = clienteRepository.findByEmail(email);
        return new ClienteDTO(cliente.getNome(),cliente.getCelular());
    }

}
