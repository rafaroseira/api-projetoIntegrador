package com.example.projeto.api.dto;

public class ClienteDTO {
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

    public ClienteDTO() {
    }
    public ClienteDTO(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }
    
}
