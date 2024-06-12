package com.example.projeto.api.dto;

import com.example.projeto.api.model.EnumSiglaEstado;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreatePetShopDTO {

    @NotBlank(message = "O campo 'nome' é obrigatório")
    @Size(min = 2, max = 45, message = "Nome deve ter entre 2 e 45 caracteres")
    private String nome;

    @NotBlank(message = "O campo 'email' é obrigatório")
    @Email(message = "Digite um email válido")
    private String email;

    @NotBlank(message = "O campo 'senha' é obrigatório")
    @Size(min = 1, max = 45, message = "Senha deve ter entre 1 e 45 caracteres")
    private String senha;

    @NotNull
    private String telefone;

    @NotBlank(message = "O campo 'celular' é obrigatório")
    @Size(min = 11, max = 11, message = "Celular deve ter 11 números (DDD incluso)")
    private String celular;

    @NotBlank(message = "O campo 'cidade' é obrigatório")
    @Size(min = 2, max = 45, message = "Cidade deve ter entre 2 e 45 caracteres")
    private String cidade;

    @NotNull(message = "O campo 'estado' é obrigatório")
    private EnumSiglaEstado estado; //PR, SP...

    @NotBlank(message = "O campo 'rua' é obrigatório")
    @Size(min = 2, max = 45, message = "Rua deve ter entre 2 e 45 caracteres")
    private String rua;

    @NotBlank(message = "O campo 'bairro' é obrigatório")
    @Size(min = 2, max = 45, message = "Bairro deve ter entre 2 e 45 caracteres")
    private String bairro;

    @NotNull(message = "O campo 'número' é obrigatório")
    @Max(value = Short.MAX_VALUE, message = "Número deve ter até 5 dígitos")
    private short numero;
    
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
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
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
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public EnumSiglaEstado getEstado() {
        return estado;
    }
    public void setEstado(EnumSiglaEstado estado) {
        this.estado = estado;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public short getNumero() {
        return numero;
    }
    public void setNumero(short numero) {
        this.numero = numero;
    }
    
    public CreatePetShopDTO() {
    }

    public CreatePetShopDTO(String nome, String email, String senha, String telefone, String celular,
            String cidade, EnumSiglaEstado estado, String rua, String bairro, short numero) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.celular = celular;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

}
