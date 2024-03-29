package com.example.projeto.api.model;

import java.util.Set;
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

    @Column
    private String descricao;

    @Column
    private float preco;

    @ManyToMany(mappedBy = "servicos")
    private Set<Agendamento> agendamentos;

    @ManyToOne
    @JoinColumn(name = "pet_shop", referencedColumnName = "id")
    private PetShop petShop;
}
