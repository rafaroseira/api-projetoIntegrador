package com.example.projeto.api.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.projeto.api.model.Servico;

public interface ServicoRepository extends CrudRepository<Servico,Integer>{
    public Servico findById(int id);
    public List<Servico> findAll();
}
