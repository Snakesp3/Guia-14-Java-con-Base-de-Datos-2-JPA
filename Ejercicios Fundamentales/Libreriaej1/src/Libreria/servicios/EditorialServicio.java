/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.servicios;

import Libreria.entidades.Editorial;
import Libreria.entidades.Libro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EditorialServicio {

    EntityManagerFactory em = Persistence.createEntityManagerFactory("LibreriaJPA");
    EntityManager emf = em.createEntityManager();
    Editorial e1 = new Editorial();

    public void crearEditorial() {

        try {

            e1.setId(1);
            e1.setNombre("ProfeciasdeEGG");
            e1.setAlta(true);

            emf.getTransaction().begin();
            emf.persist(e1);
            emf.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }

    }

    public Editorial buscarEditorialId(int id) {

        try {
            return e1 = emf.find(Editorial.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

}
