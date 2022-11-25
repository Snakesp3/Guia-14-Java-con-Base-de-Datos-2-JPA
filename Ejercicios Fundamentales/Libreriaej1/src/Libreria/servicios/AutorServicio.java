/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.servicios;

import Libreria.entidades.Autor;
import Libreria.entidades.Editorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mexi_
 */
public class AutorServicio {

    EntityManagerFactory em = Persistence.createEntityManagerFactory("LibreriaJPA");
    EntityManager emf = em.createEntityManager();
    Autor a1 = new Autor();

    public void crearAutor() {

        try {

            emf.getTransaction().begin();
            emf.persist(a1);
            emf.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }

    }

    public Autor buscarAutorId(int id) {

        try {
            return a1 = emf.find(Autor.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

}
