package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.projeto.api.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Integer>{
    public Cliente findById(int id);
    
    //Outra alternativa seria nomear o método como findByUsuarioEmail
    @Query(value = "SELECT c FROM Cliente c WHERE c.usuario.email = :email")
    public Cliente findByEmail(String email);
}
