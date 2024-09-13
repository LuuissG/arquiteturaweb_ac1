package com.example.atividadeac1.controllers;

import com.example.atividadeac1.models.Categoria;
import com.example.atividadeac1.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCategoria(@RequestBody Categoria categoria) {
        categoriaRepository.salvar(categoria);
    }

    @GetMapping
    public List<Categoria> obterCategorias() {
        return categoriaRepository.selecionarTodos();
    }
}
