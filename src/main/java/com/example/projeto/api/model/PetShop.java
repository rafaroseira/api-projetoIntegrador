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

    @OneToOne(cascade = CascadeType.ALL)
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public PetShop() {
    }

    public PetShop(String nome, String email, String senha, String telefone, String celular, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
    }
    
}
