package com.example.projeto.api.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.projeto.api.model.Profissional;

public interface ProfissionalRepository extends CrudRepository<Profissional,Integer>{
    public Profissional findById(int id);
    public List<Profissional> findAll();
}
