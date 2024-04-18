package com.example.projeto.api.dto;

public class CreateProfissionalDTO extends ProfissionalDTO{

    private int idPetShop;

    public int getIdPetShop() {
        return idPetShop;
    }

    public void setIdPetShop(int idPetShop) {
        this.idPetShop = idPetShop;
    }

    public CreateProfissionalDTO(){
        super();
    }
}
