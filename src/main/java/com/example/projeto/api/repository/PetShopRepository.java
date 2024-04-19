package com.example.projeto.api.repository;

import com.example.projeto.api.model.PetShop;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PetShopRepository extends CrudRepository<PetShop, Integer> {
    public PetShop findByEmail(String email);
    public PetShop findById(int id);
    public List<PetShop> findAll();
}
