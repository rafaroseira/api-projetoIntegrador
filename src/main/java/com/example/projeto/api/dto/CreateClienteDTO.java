package com.example.projeto.api.dto;

public class CreateClienteDTO extends ClienteDTO {
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CreateClienteDTO(){
        super();
    }
    
}
