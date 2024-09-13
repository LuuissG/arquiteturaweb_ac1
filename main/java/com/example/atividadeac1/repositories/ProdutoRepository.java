package com.example.atividadeac1.repositories;

import com.example.atividadeac1.models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto produto) {
        if (produto.getId() == null) {
            entityManager.persist(produto); 
        } else {
            entityManager.merge(produto); 
        }
        return produto;
    }

    @Transactional
    public void excluir(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }

    public List<Produto> selecionarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }

    public Produto selecionarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }
}
