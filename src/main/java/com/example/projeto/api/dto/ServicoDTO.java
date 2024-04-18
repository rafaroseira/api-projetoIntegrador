package com.example.projeto.api.dto;

import com.example.projeto.api.model.Servico;

public class ServicoDTO {

    private int id;
    private String descricao;
    private float preco;
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public ServicoDTO() {
    }

    public ServicoDTO(String descricao, float preco, int id) {
        this.descricao = descricao;
        this.preco = preco;
        this.id = id;
    }
    
    public ServicoDTO(Servico servico){
        descricao = servico.getDescricao();
        preco = servico.getPreco();
        id = servico.getId();
    }
    
}
