package com.example.projeto.api.dto;

import com.example.projeto.api.model.EnumSiglaEstado;

public class CreatePetShopDTO {
    private int id; //não precisa incluir na tela de cadastro
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String celular;
    private String cidade;
    private EnumSiglaEstado estado; //PR, SP...
    private String rua;
    private String bairro;
    private short numero;
    private String cep;
    
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
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    public CreatePetShopDTO() {
    }

    public CreatePetShopDTO(int id, String nome, String email, String senha, String telefone, String celular,
            String cidade, EnumSiglaEstado estado, String rua, String bairro, short numero, String cep) {
        this.id = id;
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
        this.cep = cep;
    }

}
