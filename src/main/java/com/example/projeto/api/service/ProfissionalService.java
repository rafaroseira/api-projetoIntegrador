package com.example.projeto.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projeto.api.dto.CreateProfissionalDTO;
import com.example.projeto.api.dto.ProfissionalDTO;
import com.example.projeto.api.dto.UpdateProfissionalDTO;
import com.example.projeto.api.model.PetShop;
import com.example.projeto.api.model.Profissional;
import com.example.projeto.api.repository.PetShopRepository;
import com.example.projeto.api.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PetShopRepository petShopRepository;

    public ProfissionalDTO cadastrar(CreateProfissionalDTO createDTO){
        PetShop petshop = petShopRepository.findById(createDTO.getIdPetShop());
        Profissional profissional = new Profissional(createDTO,petshop);
        profissional = profissionalRepository.save(profissional);
        return new ProfissionalDTO(profissional);
    }

    public void excluir(int id){
        profissionalRepository.deleteById(id);
    }

    public ProfissionalDTO recuperar(int id){
        Profissional profissional = profissionalRepository.findById(id);
        return new ProfissionalDTO(profissional);
    }

    public ProfissionalDTO atualizar(UpdateProfissionalDTO updateDTO){
        Profissional profissional = profissionalRepository.findById(updateDTO.getIdProfissional());
        profissional.setNome(updateDTO.getNome());
        profissional = profissionalRepository.save(profissional);
        return new ProfissionalDTO(profissional);
    }

    public List<ProfissionalDTO> encontrarTodos(){
        List<Profissional> profissionalList = profissionalRepository.findAll();
        List<ProfissionalDTO> profissionalDTOlist = new ArrayList<ProfissionalDTO>();
        for(Profissional profissional : profissionalList){
            ProfissionalDTO dto = new ProfissionalDTO(profissional);
            profissionalDTOlist.add(dto);
        }
        return profissionalDTOlist;
    }
}
