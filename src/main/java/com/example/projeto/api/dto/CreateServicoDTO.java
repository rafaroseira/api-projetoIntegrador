package com.example.projeto.api.dto;

public class CreateServicoDTO extends ServicoDTO {

    private int idPetShop;

    public int getIdPetShop() {
        return idPetShop;
    }

    public void setIdPetShop(int idPetShop) {
        this.idPetShop = idPetShop;
    }

    public CreateServicoDTO(){
        super(); 
    }
}
