package com.example.projeto.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.CreateProfissionalDTO;
import com.example.projeto.api.dto.ProfissionalDTO;
import com.example.projeto.api.dto.UpdateProfissionalDTO;
import com.example.projeto.api.service.ProfissionalService;

@RestController
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;
    
    @PostMapping("/profissional/cadastro")
    public ProfissionalDTO adicionarProfissional(@RequestBody CreateProfissionalDTO dto) {
        return profissionalService.cadastrar(dto);
    }

    @GetMapping("/profissional/recuperar/{id}")
    public ProfissionalDTO recuperarProfissional(@PathVariable int id) {
        return profissionalService.recuperar(id);
    }
    
    @DeleteMapping("/profissional/excluir/{id}")
    public ResponseEntity<?> excluirProfissional(@PathVariable int id){
        profissionalService.excluir(id);
        return ResponseEntity.ok().body("Profissional Excluído!");
    }

    @PutMapping("/profissional/atualizar")
    public ProfissionalDTO atualizarProfissional(@RequestBody UpdateProfissionalDTO dto) {
        return profissionalService.atualizar(dto);
    }

    @GetMapping("/profissional/recuperar/todos")
    public List<ProfissionalDTO> listarTodos() {
        return profissionalService.encontrarTodos();
    }
    
}
