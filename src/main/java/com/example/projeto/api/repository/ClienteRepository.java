package com.example.projeto.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.projeto.api.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente,Integer>{

}
