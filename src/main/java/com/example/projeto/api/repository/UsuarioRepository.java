package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.projeto.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String> {
    public UserDetails findByEmail(String email);
}
