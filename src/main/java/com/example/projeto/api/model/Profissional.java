package com.example.projeto.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 45)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "pet_shop", referencedColumnName = "id")
    private PetShop petShop;

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;
}
