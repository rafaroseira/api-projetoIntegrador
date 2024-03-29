package com.example.projeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.model.PetShop;
import com.example.projeto.api.service.PetShopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PetShopController {

    @Autowired
    private PetShopService petShopService;

    @PostMapping("/cadastro/petshop")
    public PetShop cadastrar(@RequestBody PetShop petShop) {
        return petShopService.cadastrar(petShop);
    }
    
}
