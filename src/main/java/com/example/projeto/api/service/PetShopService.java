package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.projeto.api.dto.CreatePetShopDTO;
import com.example.projeto.api.dto.EnderecoDTO;
import com.example.projeto.api.dto.PetShopDTO;
import com.example.projeto.api.dto.UpdateEnderecoPetShopDTO;
import com.example.projeto.api.dto.UpdatePetShopDTO;
import com.example.projeto.api.model.Endereco;
import com.example.projeto.api.model.Estado;
import com.example.projeto.api.model.PetShop;
import com.example.projeto.api.repository.EnderecoRepository;
import com.example.projeto.api.repository.PetShopRepository;

@Service
public class PetShopService {

    @Autowired
    private PetShopRepository petShopRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public PetShopDTO cadastrar(CreatePetShopDTO createDTO){
        Estado estado = new Estado(createDTO.getEstado());
        Endereco endereco = new Endereco(createDTO.getCidade(),estado,createDTO.getRua(),
        createDTO.getBairro(),createDTO.getNumero(),createDTO.getCep());
        endereco = enderecoRepository.save(endereco);
        PetShop petShop = new PetShop(createDTO.getNome(), createDTO.getEmail(), createDTO.getSenha(), 
        createDTO.getTelefone(), createDTO.getCelular(), endereco);
        petShop = petShopRepository.save(petShop);
        PetShopDTO petShopDTO = new PetShopDTO(petShop);
        return petShopDTO;
    }

    public PetShopDTO recuperar(int id){
        PetShop petShop = petShopRepository.findById(id);
        return new PetShopDTO(petShop);
    }

    public void excluir(int id){
        petShopRepository.deleteById(id);
    }

    @Transactional
    public PetShopDTO atualizarDados(UpdatePetShopDTO updateDTO){
        PetShop petShop = petShopRepository.findById(updateDTO.getId());
        petShop.setNome(updateDTO.getNome());
        petShop.setCelular(updateDTO.getCelular());
        petShop.setTelefone(updateDTO.getTelefone());
        petShop = petShopRepository.save(petShop);
        PetShopDTO petShopDTO = new PetShopDTO(petShop);
        return petShopDTO;
    }

    @Transactional
    public EnderecoDTO atualizarEndereco(UpdateEnderecoPetShopDTO updateDTO){
        PetShop petShop = petShopRepository.findById(updateDTO.getId());
        Endereco endereco = petShop.getEndereco();
        Estado estado = new Estado(updateDTO.getEstado());
        endereco.setCidade(updateDTO.getCidade());
        endereco.setEstado(estado);
        endereco.setBairro(updateDTO.getBairro());
        endereco.setRua(updateDTO.getRua());
        endereco.setNumero(updateDTO.getNumero());
        endereco.setCep(updateDTO.getCep());
        endereco = enderecoRepository.save(endereco);
        return new EnderecoDTO(endereco);
    }
}
