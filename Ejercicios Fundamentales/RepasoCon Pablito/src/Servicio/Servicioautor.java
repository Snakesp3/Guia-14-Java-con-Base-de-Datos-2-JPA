package Servicio;

import Entidades.Autor;
import Entidades.Editorial;
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

    Autor au = new Autor();

    public void crearAutor() {
        try {
            System.out.println("ingrese el Id del autor");
            au.setId(leer.nextInt());
            System.out.println("Ingrese el nombre del autor");
            au.setNombre(leer.next());

            au.setAlta(true);
            em.getTransaction().begin();
            em.persist(au);
            em.getTransaction().commit();
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
}
