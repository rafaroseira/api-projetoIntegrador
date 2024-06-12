package com.example.projeto.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.projeto.api.dto.CreatePetShopDTO;
import com.example.projeto.api.dto.PetShopDTO;
import com.example.projeto.api.model.Endereco;
import com.example.projeto.api.model.EnumRole;
import com.example.projeto.api.model.Estado;
import com.example.projeto.api.model.PetShop;
import com.example.projeto.api.model.Role;
import com.example.projeto.api.model.Usuario;
import com.example.projeto.api.repository.EnderecoRepository;
import com.example.projeto.api.repository.PetShopRepository;
import com.example.projeto.api.repository.UsuarioRepository;

@Service
public class PetShopService {

    @Autowired
    private PetShopRepository petShopRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public ResponseEntity<?> cadastrar(CreatePetShopDTO dto){
        Usuario usuario = new Usuario(dto.getEmail(),dto.getSenha());
        Role role = new Role(EnumRole.PETSHOP);
        usuario.getRoles().add(role);
        usuario = usuarioRepository.save(usuario);

        Estado estado = new Estado(dto.getEstado());
        Endereco endereco = new Endereco(dto.getCidade(),estado,dto.getRua(),
        dto.getBairro(),dto.getNumero());
        enderecoRepository.save(endereco);

        PetShop petShop = new PetShop(dto.getNome(),dto.getTelefone(),dto.getCelular(),
        endereco,usuario);
        petShopRepository.save(petShop);

        return ResponseEntity.ok().body("Pet Shop cadastrado!");
    }

    public List<PetShopDTO> pesquisar(String cidade){
        List<PetShop> petShops = petShopRepository.pesquisaPorCidade(cidade);
        List<PetShopDTO> dtoList = new ArrayList<PetShopDTO>();

        for(PetShop petShop : petShops){
            PetShopDTO dto = new PetShopDTO(petShop.getId(),petShop.getNome(), petShop.getEndereco());
            dtoList.add(dto);
        }

        return dtoList;
    }

    public PetShopDTO recuperar(String email){
        PetShop petShop = petShopRepository.findByEmail(email);
        return new PetShopDTO(petShop.getId(),petShop.getNome(),petShop.getEndereco());
    }

}
