package com.example.projeto.api.model;

import java.util.Set;

import com.example.projeto.api.dto.CreateServicoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 90)
    private String descricao;

    @Column(nullable = false)
    private float preco;

    @ManyToMany(mappedBy = "servicos")
    private Set<Agendamento> agendamentos;

    @ManyToOne
    @JoinColumn(name = "pet_shop", referencedColumnName = "id")
    private PetShop petShop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Servico() {
    }

    public Servico(CreateServicoDTO dto, PetShop petshop){
        descricao = dto.getDescricao();
        preco = dto.getPreco();
        this.petShop = petshop;
    }
}
