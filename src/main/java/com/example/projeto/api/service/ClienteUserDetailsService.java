package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.projeto.api.model.Cliente;
import com.example.projeto.api.repository.ClienteRepository;
import com.example.projeto.api.security.ClienteUserDetails;

public class ClienteUserDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente == null) {
            throw new UsernameNotFoundException("Cliente não encontrado!");
        }
         
        return new ClienteUserDetails(cliente);
    }
}
