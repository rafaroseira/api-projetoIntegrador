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

    @Column(columnDefinition = "CHAR(10)")
    private String telefone;

    @Column(nullable = false, columnDefinition = "CHAR(11)")
    private String celular;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email", unique = true, nullable = false)
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco", referencedColumnName = "id", unique = true, nullable = false)
    private Endereco endereco;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<Profissional> profissionais;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<HorarioFuncionamento> horariosFuncionamento;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<Agendamento> agendamentos;

    @OneToMany(mappedBy = "petShop", cascade = CascadeType.ALL)
    private Set<Servico> servicos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PetShop() {
    }

    public PetShop(String nome, String telefone, String celular, Endereco endereco, Usuario usuario) {
        this.nome = nome;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
        this.usuario = usuario;
    }
    
}
