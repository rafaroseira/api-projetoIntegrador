package com.example.projeto.api.dto;

public class UpdateEnderecoPetShopDTO extends EnderecoDTO {

    private int idPetShop;

    public int getIdPetShop() {
        return idPetShop;
    }
    public void setIdPetShop(int idPetShop) {
        this.idPetShop = idPetShop;
    }

    public UpdateEnderecoPetShopDTO(){
        super();
    }
   
}
