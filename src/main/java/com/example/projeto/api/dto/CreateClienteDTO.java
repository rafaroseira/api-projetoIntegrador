package com.example.projeto.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateClienteDTO{

    @NotBlank(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 45, message = "Nome deve ter entre 2 e 45 caracteres")
    private String nome;

    @NotBlank(message = "O campo 'email' é obrigatório")
    @Email(message = "Digite um email válido")
    @Size(max = 45, message = "Email deve ter até 45 caracteres")
    private String email;

    @NotBlank(message = "O campo 'celular' é obrigatório")
    @Size(min = 11, max = 11, message = "Celular deve ter 11 números (DDD incluso)")
    private String celular;

    @NotBlank(message = "O campo 'senha' é obrigatório")
    @Size(min = 1, max = 45, message = "Senha deve ter entre 1 e 45 caracteres")
    private String senha;
    
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
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CreateClienteDTO() {
    }
    
    public CreateClienteDTO(String nome, String email, String celular, String senha) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.senha = senha;
    }
    
}
