package com.example.projeto.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Enumerated(value = EnumType.STRING)
    private EnumRole nome;

    public EnumRole getNome() {
        return nome;
    }

    public void setNome(EnumRole nome) {
        this.nome = nome;
    }

    public Role(EnumRole nome) {
        this.nome = nome;
    }

    public Role() {
    }
    
}
