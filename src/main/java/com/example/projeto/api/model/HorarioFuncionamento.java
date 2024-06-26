package com.example.projeto.api.model;

import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class HorarioFuncionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalTime inicio;

    @Column(nullable = false)
    private LocalTime termino;

    @ManyToOne
    @JoinColumn(name = "dia_semana", referencedColumnName = "dia")
    private DiaSemana diaSemana;

    @ManyToOne
    @JoinColumn(name = "pet_shop", referencedColumnName = "id")
    private PetShop petShop;
}
