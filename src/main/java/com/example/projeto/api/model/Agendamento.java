package com.example.projeto.api.model;

import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Agendamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate data;
    
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "pet_shop", referencedColumnName = "id")
    private PetShop petShop;

    @ManyToOne
    @JoinColumn(name = "profissional", referencedColumnName = "id")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "horario", referencedColumnName = "horario")
    private Horario horario;

    @ManyToMany
    @JoinTable(name = "servicos_agendamento",
        joinColumns = @JoinColumn(name = "agendamento"),
        inverseJoinColumns = @JoinColumn(name = "servico")
    )
    private Set<Servico> servicos;

}
