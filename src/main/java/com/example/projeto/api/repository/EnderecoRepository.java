package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.projeto.api.model.Endereco;
import com.example.projeto.api.model.EnumSiglaEstado;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

    /*@Query(value = "UPDATE endereco JOIN pet_shop ON endereco.id = pet_shop.endereco SET "+
    "cidade = :cidade, estado = :cidade, rua = :rua, bairro = :bairro, numero = :numero, cep = :cep WHERE pet_shop.id = :id")
    public Endereco updateEndereco(String cidade, EnumSiglaEstado estado, String rua,
    String bairro, short numero, String cep ,int id);*/
}
