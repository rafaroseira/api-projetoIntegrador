package com.example.projeto.api.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class PetShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String cnpj;

    @Column
    private String telefone;

    @Column
    private String celular;

    @Column
    private float precoTosa;

    @Column
    private float precoBanho;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id", unique = true)
    private Endereco endereco;

    @OneToOne(mappedBy = "petShop", cascade = CascadeType.ALL) //torna bidirecional
    private UserPetShop userPetShop;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private List<Profissional> profissionais;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private List<HorarioFuncionamento> horariosFuncionamento;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;
    
}
