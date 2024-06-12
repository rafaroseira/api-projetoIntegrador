package com.example.projeto.api.repository;

import com.example.projeto.api.model.PetShop;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PetShopRepository extends CrudRepository<PetShop, Integer> {
    public PetShop findById(int id);
    public List<PetShop> findAll();

    @Query(value = "SELECT p FROM PetShop p JOIN p.endereco e WHERE e.cidade = ?1")
    public List<PetShop> pesquisaPorCidade(String cidade);

    //Outra alternativa seria nomear o método como findByUsuarioEmail
    @Query(value = "SELECT p FROM PetShop p WHERE p.usuario.email = :email")
    public PetShop findByEmail(String email);
}
