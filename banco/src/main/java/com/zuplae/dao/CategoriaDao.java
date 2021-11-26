package com.zuplae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zuplae.model.Categoria;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        this.entityManager = factory.createEntityManager();
    }

    public int create(Categoria model) {

        this.entityManager.getTransaction().begin(); // Begin vai "Startar"
        this.entityManager.persist(model); // Insert - Update
        this.entityManager.getTransaction().commit();
        return model.getId();
    }

    public List<Categoria> read() {
        return this.entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    public void update(Categoria model){
        this.entityManager.getTransaction().begin(); // Begin vai "Startar"
        this.entityManager.merge(model); // Insert - Update
        this.entityManager.getTransaction().commit();
    }
    public void delete(int id){
        Categoria model = this.entityManager.find(Categoria.class, id); 
        this.entityManager.getTransaction().begin(); 
        this.entityManager.remove(model);;
        this.entityManager.getTransaction().commit();
    }
}
