package com.example.projeto.api.dto;

import com.example.projeto.api.model.Endereco;
import com.example.projeto.api.model.EnumSiglaEstado;

public class EnderecoDTO {
    private String cidade;
    private EnumSiglaEstado estado;
    private String rua;
    private String bairro;
    private short numero;
    private String cep;

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

    public EnderecoDTO() {
    }

    public EnderecoDTO(String cidade, EnumSiglaEstado estado, String rua, String bairro, short numero, String cep) {
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
    }

    public EnderecoDTO(Endereco endereco){
        cidade = endereco.getCidade();
        estado = endereco.getEstado().getEstado();
        rua = endereco.getRua();
        bairro = endereco.getBairro();
        numero = endereco.getNumero();
        cep = endereco.getCep();
    }
    
}
