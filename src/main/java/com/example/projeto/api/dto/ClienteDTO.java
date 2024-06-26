package com.example.projeto.api.dto;

import com.example.projeto.api.model.Cliente;

public class ClienteDTO {
    private int id; //não precisa inserir na tela de cadastro
    private String nome;
    private String email;
    private String celular;
    
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

    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    public ClienteDTO() {
    }

    public ClienteDTO(int id, String nome, String email, String celular) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
        celular = cliente.getCelular();
    }

}
