package com.example.projeto.api.dto;

public class AuthenticationDTO {
    private String email;
    private String senha;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public AuthenticationDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
    public AuthenticationDTO() {
    }
    
}