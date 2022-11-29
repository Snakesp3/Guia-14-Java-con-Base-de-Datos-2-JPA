package Servicio;

import Entidades.Autor;
import Entidades.Editorial;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servicioautor {

    //Metodo que usa la unidad de persistencia para manejar los datos
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RepasoPablito");

//intermediario entre el programa y base de datos
    EntityManager em = emf.createEntityManager();

    Scanner leer = new Scanner(System.in);

    List<Autor> aux1 = new ArrayList();

    Autor au = new Autor();

    public void crearAutor() {
        try {
            Integer autor = leer.nextInt();
            if (buscarAutorId(autor)==null) {
            System.out.println("ingrese el Id del autor");
            au.setId(leer.nextInt());
            System.out.println("Ingrese el nombre del autor");
            au.setNombre(leer.next());

            au.setAlta(true);
            em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit(); 
            }else{
                System.out.println("El Autor ya EXISTEEEEEEEEEEEEEEEEEEEEEE!");
                
            }
            
        } catch (Exception e) {
            throw e;
        }

    }

    public Autor buscarAutorId(int id) {

        try {

            return au = em.find(Autor.class, id);

        } catch (Exception e) {
            throw e;
        }

    }

    public void modificarAutor(String nombre) {

        try {
            Autor autor = em.find(Autor.class, 22);
            System.out.print("->");
            autor.setNombre(nombre);
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarAutor() {

        try {
            Autor autor = em.find(Autor.class, 3);
            System.out.println("<<<Eliminar la editorial>>>");
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }
    //8) Búsqueda de un Autor por nombre.

    public List buscarAutor(String Autor) {

        try {

            return aux1 = em.createQuery("Select a from Autor a where a.nombre like:nombre")
                    .setParameter("nombre", Autor).getResultList();

        } catch (Exception e) {
            throw e;
        }

    }
}
