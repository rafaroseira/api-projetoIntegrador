package com.example.projeto.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.CreatePetShopDTO;
import com.example.projeto.api.dto.EnderecoDTO;
import com.example.projeto.api.dto.PetShopDTO;
import com.example.projeto.api.dto.UpdateEnderecoPetShopDTO;
import com.example.projeto.api.dto.UpdatePetShopDTO;
import com.example.projeto.api.service.PetShopService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class PetShopController {

    @Autowired
    private PetShopService petShopService;

    @PostMapping("/petshop/cadastro")
    public PetShopDTO cadastrarPetShop(@RequestBody CreatePetShopDTO createDTO) {
        return petShopService.cadastrar(createDTO);
    }

    @GetMapping("/petshop/recuperar/{id}")
    public PetShopDTO recuperarPetShop(@PathVariable int id) {
        return petShopService.recuperar(id);
    }
    
    @DeleteMapping("/petshop/excluir/{id}")
    public ResponseEntity<?> excluirPetShop(@PathVariable int id) {
        petShopService.excluir(id);
        return ResponseEntity.ok().body("Conta excluída!");
    }

    @PutMapping("/petshop/atualizar-dados")
    public PetShopDTO atualizarDadosPetShop(@RequestBody UpdatePetShopDTO dto) {
        return petShopService.atualizarDados(dto);
    }

    @PutMapping("/petshop/atualizar-endereco")
    public EnderecoDTO atualizarEnderecoPetShop(@RequestBody UpdateEnderecoPetShopDTO dto) {
        return petShopService.atualizarEndereco(dto);
    }

    @GetMapping("/petshop/recuperar/todos")
    public List<PetShopDTO> listarTodos() {
        return petShopService.encontrarTodos();
    }

}
