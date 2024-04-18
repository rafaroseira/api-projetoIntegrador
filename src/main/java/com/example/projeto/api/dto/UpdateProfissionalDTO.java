package com.example.projeto.api.dto;

public class UpdateProfissionalDTO extends ProfissionalDTO{

    private int idProfissional;

    public int getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(int idProfissional) {
        this.idProfissional = idProfissional;
    }

    public UpdateProfissionalDTO(){
        super();
    }
}
