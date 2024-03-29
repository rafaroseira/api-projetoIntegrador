package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projeto.api.model.PetShop;
import com.example.projeto.api.repository.PetShopRepository;

@Service
public class PetShopService {
    
    @Autowired
    private PetShopRepository petShopRepository;

    public PetShop cadastrar(PetShop petShop){
        return petShopRepository.save(petShop);
    }
}
