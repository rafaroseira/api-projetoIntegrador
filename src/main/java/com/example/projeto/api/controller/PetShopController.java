package com.example.projeto.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.projeto.api.dto.CreatePetShopDTO;
import com.example.projeto.api.dto.PetShopDTO;
import com.example.projeto.api.model.Usuario;
import com.example.projeto.api.service.PetShopService;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PetShopController {

    @Autowired
    private PetShopService petShopService;

    @PostMapping("/cadastro/petshop")
    public ResponseEntity<?> cadastrarPetShop(@Valid @RequestBody CreatePetShopDTO dto) {
        return petShopService.cadastrar(dto);
    }

    @GetMapping("/pesquisa/petshop")
    public List<PetShopDTO> pesquisarPetShops(@RequestParam String cidade) {
        return petShopService.pesquisar(cidade);
    }

    @GetMapping("/petshop/hello")
    public String privateHello(@AuthenticationPrincipal Usuario usuario){
        PetShopDTO dto = petShopService.recuperar(usuario.getUsername());
        return "hello, " + dto.getNome();
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
