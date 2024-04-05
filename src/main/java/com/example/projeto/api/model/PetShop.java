package com.example.projeto.api.model;

import java.util.Set;
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

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45, unique = true)
    private String email;

    @Column(nullable = false, length = 45)
    private String senha;

    @Column(columnDefinition = "CHAR(10)")
    private String telefone;

    @Column(nullable = false, columnDefinition = "CHAR(11)")
    private String celular;

    @OneToOne
    @JoinColumn(name = "endereco", referencedColumnName = "id", unique = true)
    private Endereco endereco;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<Profissional> profissionais;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<HorarioFuncionamento> horariosFuncionamento;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<Agendamento> agendamentos;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<Servico> servicos;
    
}
