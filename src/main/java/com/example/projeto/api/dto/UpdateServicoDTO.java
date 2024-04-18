package com.example.projeto.api.dto;

public class UpdateServicoDTO extends ServicoDTO{

    private int idServico;

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public UpdateServicoDTO(){
        super();
    }
}
