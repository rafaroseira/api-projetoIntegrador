package com.example.projeto.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.projeto.api.dto.CreateServicoDTO;
import com.example.projeto.api.dto.ServicoDTO;
import com.example.projeto.api.dto.UpdateServicoDTO;
import com.example.projeto.api.model.PetShop;
import com.example.projeto.api.model.Servico;
import com.example.projeto.api.repository.PetShopRepository;
import com.example.projeto.api.repository.ServicoRepository;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PetShopRepository petShopRepository;

    public ServicoDTO cadastrar(CreateServicoDTO createDTO){
        PetShop petshop = petShopRepository.findById(createDTO.getIdPetShop());
        Servico servico = new Servico(createDTO,petshop);
        servico = servicoRepository.save(servico);
        return new ServicoDTO(servico);
    }

    public void excluir(int id){
        servicoRepository.deleteById(id);
    }

    public ServicoDTO recuperar(int id){
        Servico servico = servicoRepository.findById(id);
        return new ServicoDTO(servico);
    }

    public ServicoDTO atualizar(UpdateServicoDTO updateDTO){
        Servico servico = servicoRepository.findById(updateDTO.getIdServico());
        servico.setDescricao(updateDTO.getDescricao());
        servico.setPreco(updateDTO.getPreco());
        servico = servicoRepository.save(servico);
        return new ServicoDTO(servico);
    }

    public List<ServicoDTO> encontrarTodos(){
        List<Servico> servicoList = servicoRepository.findAll();
        List<ServicoDTO> servicoDTOlist = new ArrayList<ServicoDTO>();
        for(Servico servico : servicoList){
            ServicoDTO dto = new ServicoDTO(servico);
            servicoDTOlist.add(dto);
        }
        return servicoDTOlist;
    }
}
