package com.example.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.dto.ClienteDTO;
import com.example.projeto.api.dto.CreateClienteDTO;
import com.example.projeto.api.model.Usuario;
import com.example.projeto.api.service.ClienteService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/hello")
    public String privateHello(@AuthenticationPrincipal Usuario usuario){
        ClienteDTO dto = clienteService.recuperar(usuario.getUsername());
        return "hello," + dto.getNome();
    }

    @PostMapping("/cadastro/cliente")
    public ResponseEntity<?> cadastrarCliente(@Valid @RequestBody CreateClienteDTO dto){
        return clienteService.cadastrar(dto);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
    MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    
}
