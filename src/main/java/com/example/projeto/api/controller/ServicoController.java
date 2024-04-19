package com.example.projeto.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.CreateServicoDTO;
import com.example.projeto.api.dto.ServicoDTO;
import com.example.projeto.api.dto.UpdateServicoDTO;
import com.example.projeto.api.service.ServicoService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ServicoController {

    @Autowired
    private ServicoService servicoService;
    
    @PostMapping("/servico/cadastro")
    public ServicoDTO adicionarServico(@RequestBody CreateServicoDTO dto) {
        return servicoService.cadastrar(dto);
    }

    @GetMapping("/servico/recuperar/{id}")
    public ServicoDTO recuperarServico(@PathVariable int id) {
        return servicoService.recuperar(id);
    }
    
    @DeleteMapping("/servico/excluir/{id}")
    public ResponseEntity<?> excluirServico(@PathVariable int id){
        servicoService.excluir(id);
        return ResponseEntity.ok().body("Servico Excluído!");
    }

    @PutMapping("/servico/atualizar")
    public ServicoDTO atualizarServico(@RequestBody UpdateServicoDTO dto) {
        return servicoService.atualizar(dto);
    }

    @GetMapping("/servico/recuperar/todos")
    public List<ServicoDTO> listarTodos() {
        return servicoService.encontrarTodos();
    }
    
}
