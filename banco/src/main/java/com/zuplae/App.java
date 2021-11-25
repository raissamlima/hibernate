package com.zuplae;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.zuplae.model.Categoria;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("---- Sistema de Banco! -----");

        Categoria model = new Categoria();
        model.setNome("JPA no MAVEN");
        model.setDescricao("Jpa");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin(); // Begin vai "Startar"
        em.persist(model); // Insert - Update 
        em.getTransaction().commit();

        List<Categoria> lista = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();

        for (Categoria categoria : lista) {
            System.out.printf("%d - %s - %s\n", categoria.getId(), categoria.getNome(), categoria.getDescricao());
        }
    }
}
