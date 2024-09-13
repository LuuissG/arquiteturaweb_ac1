package com.example.atividadeac1.controllers;

import com.example.atividadeac1.models.Produto;
import com.example.atividadeac1.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarProduto(@RequestBody Produto produto) {
        produtoRepository.salvar(produto);
    }

    @GetMapping
    public List<Produto> obterProdutos() {
        return produtoRepository.selecionarTodos();
    }

    @GetMapping("/{id}")
    public Produto obterProdutoPorId(@PathVariable Long id) {
        return produtoRepository.selecionarPorId(id);
    }
}
