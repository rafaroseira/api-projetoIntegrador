package com.example.projeto.api.dto;

import com.example.projeto.api.model.Profissional;

public class ProfissionalDTO {

    private int id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProfissionalDTO() {
    }

    public ProfissionalDTO(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    
    public ProfissionalDTO(Profissional profissional){
        nome = profissional.getNome();
        id = profissional.getId();
    }

}
