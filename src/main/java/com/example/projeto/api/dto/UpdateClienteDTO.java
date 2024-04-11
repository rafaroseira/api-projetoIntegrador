package com.example.projeto.api.dto;

import com.example.projeto.api.model.Cliente;

public class UpdateClienteDTO {

    private int id;
    private String nome;
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
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public UpdateClienteDTO() {
    }

    public UpdateClienteDTO(int id, String nome, String celular) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
    }

    public UpdateClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        celular = cliente.getCelular();
    }
  
}
