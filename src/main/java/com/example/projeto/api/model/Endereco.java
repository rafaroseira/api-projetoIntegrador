package com.example.projeto.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "estado", nullable = false)
    private Estado estado;

    @Column
    private String rua;

    @Column
    private String bairro;

    @Column
    private short numero;

    @Column
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private PetShop petShop; //torna bidirecional
}
