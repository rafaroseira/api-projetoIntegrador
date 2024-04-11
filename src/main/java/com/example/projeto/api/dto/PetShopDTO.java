package com.example.projeto.api.dto;

import com.example.projeto.api.model.PetShop;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PetShopDTO {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String celular;

    @JsonProperty("endereco")
    private EnderecoDTO endereco;

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public EnderecoDTO getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
    
    public PetShopDTO() {
    }
    
    public PetShopDTO(int id, String nome, String email, String telefone, String celular, EnderecoDTO endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }

    public PetShopDTO(PetShop petShop){
        id = petShop.getId();
        nome = petShop.getNome();
        email = petShop.getEmail();
        telefone = petShop.getTelefone();
        celular = petShop.getCelular();
        endereco = new EnderecoDTO(petShop.getEndereco().getCidade(), petShop.getEndereco().getEstado().getEstado(),
         petShop.getEndereco().getRua(), petShop.getEndereco().getBairro(),
         petShop.getEndereco().getNumero(), petShop.getEndereco().getCep());
    }
}
