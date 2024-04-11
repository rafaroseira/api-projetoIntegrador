package com.example.projeto.api.repository;

import com.example.projeto.api.model.PetShop;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PetShopRepository extends CrudRepository<PetShop, Integer> {
    public PetShop findByEmail(String email);
    public PetShop findById(int id);
    
    /*@Query(value = "SELECT endereco FROM pet_shop WHERE id = :id")
    public int getIdEndereco(int id);*/
}
