package com.example.projeto.api.dto;

import com.example.projeto.api.model.PetShop;

public class UpdatePetShopDTO {

    private int id;
    private String nome;
    private String celular;
    private String telefone;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public UpdatePetShopDTO() {
    }

    public UpdatePetShopDTO(int id, String nome, String celular, String telefone) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.telefone = telefone;
    }

    public UpdatePetShopDTO(PetShop petShop){
        id = petShop.getId();
        nome = petShop.getNome();
        celular = petShop.getCelular();
        telefone = petShop.getTelefone();
    }
    
}
