package com.example.projeto.api.dto;

import com.example.projeto.api.model.Cliente;

public class UpdateClienteDTO {
    
    private String nome;
    private String celular;

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

    public UpdateClienteDTO(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }

    public UpdateClienteDTO(Cliente cliente){
        nome = cliente.getNome();
        celular = cliente.getCelular();
    }
}
