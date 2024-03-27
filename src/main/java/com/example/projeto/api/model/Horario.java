package com.example.projeto.api.model;

import java.time.LocalTime;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Horario {

    @Id
    private LocalTime horario;

    @OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
    private List<Agendamento> agendamentos;

}
