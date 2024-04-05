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

    @Column(nullable = false, length = 45)
    private String cidade;

    @ManyToOne
    @JoinColumn(name = "estado", referencedColumnName = "estado")
    private Estado estado;

    @Column(nullable = false, length = 45)
    private String rua;

    @Column(nullable = false, length = 45)
    private String bairro;

    @Column(nullable = false)
    private short numero;

    @Column(nullable = false, columnDefinition = "CHAR(8)")
    private String cep;

    @OneToOne(mappedBy = "endereco")
    private PetShop petShop; //torna bidirecional
}
