package com.example.projeto.api.model;

import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;


@Entity
public class DiaSemana {

    @Id
    @Enumerated(value = EnumType.STRING)
    private EnumDiaSemana dia;

    @OneToMany(mappedBy = "diaSemana", cascade = CascadeType.ALL) //torna bidirecional
    private List<HorarioFuncionamento> horariosFuncionamento;
}
