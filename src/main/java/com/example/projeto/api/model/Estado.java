package com.example.projeto.api.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Estado {

    @Id
    @Enumerated(value = EnumType.STRING)
    private EnumSiglaEstado estado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    public EnumSiglaEstado getEstado() {
        return estado;
    }

    public void setEstado(EnumSiglaEstado estado) {
        this.estado = estado;
    }

    public Estado() {
    }

    public Estado(EnumSiglaEstado estado) {
        this.estado = estado;
    }

}
