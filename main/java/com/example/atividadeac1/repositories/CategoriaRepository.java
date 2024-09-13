package com.example.atividadeac1.repositories;

import com.example.atividadeac1.models.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        if (categoria.getId() == null) {
            entityManager.persist(categoria); 
        } else {
            entityManager.merge(categoria); 
        }
        return categoria;
    }

    @Transactional
    public void excluir(Long id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }

    public List<Categoria> selecionarTodos() {
        return entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    public Categoria selecionarPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }
}
