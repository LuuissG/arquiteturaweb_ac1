package com.example.atividadeac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividadeac1.models.Categoria;
import com.example.atividadeac1.models.Produto;
import com.example.atividadeac1.repositories.CategoriaRepository;
import com.example.atividadeac1.repositories.ProdutoRepository;

@SpringBootApplication
public class Atividadeac1Application {

    @Bean
    public CommandLineRunner init(
            @Autowired CategoriaRepository categoriaRepository,
            @Autowired ProdutoRepository produtoRepository) {
        return args -> {

            System.out.println(" CRIANDO AS CATEGORIAS ");
            Categoria cat1 = categoriaRepository.salvar(
                    new Categoria(null, "Eletrônicos", "Produtos eletrônicos"));
            Categoria cat2 = categoriaRepository.salvar(
                    new Categoria(null, "Video-Games", "Jogos"));

            List<Categoria> listaCategorias = categoriaRepository.selecionarTodos();
            listaCategorias.forEach(System.out::println);

		
            System.out.println("CRIANDO OS PRODUTOS");
            produtoRepository.salvar(
                    new Produto(null, "Chocolate", 20, cat1));
            produtoRepository.salvar(
                    new Produto(null, "Chinelo", 30, cat2));

            List<Produto> listaProdutos = produtoRepository.selecionarTodos();
            listaProdutos.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Atividadeac1Application.class, args);
    }
}
