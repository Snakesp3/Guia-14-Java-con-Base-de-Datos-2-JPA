package Servicio;

import Entidades.Autor;
import Entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Serviciolibro {

    /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
 administrar autores (consulta, creación, modificación y eliminación).*/
//Metodo que usa la unidad de persistencia para manejar los datos
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RepasoPablito");

//intermediario entre el programa y base de datos
    EntityManager em = emf.createEntityManager();

    Scanner leer = new Scanner(System.in);

    Libro l1 = new Libro();

    Servicioautor a1 = new Servicioautor();
    Servicioeditorial e1 = new Servicioeditorial();
    List<Libro> aux2 = new ArrayList();

    public void crearLibro() {

        try {
            System.out.println("");
            System.out.println("              *****************************************");
            System.out.println("              ***INGRESE LOS DATOS DEL LIBRO A CREAR***");
            System.out.println("              *****************************************");
            System.out.println("");
            System.out.println("<<<Ingrese el ISBN>>>");
            Long isbn = leer.nextLong();
            if (buscarLibroIsbn(isbn) == null) {
                Libro l2 = new Libro();
                System.out.print("->");
                l2.setIsbn(isbn);
                System.out.println("*********************");
                System.out.println("<<<Ingrese el Titulo>>>");
                System.out.print("->");
                l2.setTitulo(leer.next());
                System.out.println("***********************");
                System.out.println("<<<Ingrese el Año>>>");
                System.out.print("->");
                l2.setAnio(leer.nextInt());
                System.out.println("********************");
                System.out.println("<<<Cantidad de Ejemplares>>>");
                System.out.print("->");
                l2.setEjemplares(leer.nextInt());
                System.out.println("****************************");
                System.out.println("<<<Cantidad de Ejemplares Prestados>>>");
                System.out.print("->");
                l2.setEjemplaresPrestados(leer.nextInt());
                System.out.println("**************************************");
                l2.setEjemplaresRestantes(l2.getEjemplares() - l2.getEjemplaresPrestados());
                System.out.println("<<<Ingrese el Id del Autor>>>");
                System.out.print("->");
                l2.setAutor(a1.buscarAutorId(leer.nextInt()));
                System.out.println("*****************************");
                System.out.println("<<<Ingrese el Id de la Editorial>>>");
                System.out.print("->");
                l2.setEditorial(e1.buscarEditorialid(leer.nextLong()));
                System.out.println("              ****************************");
                System.out.println("              *GRACIAS POR CREAR EL LIBRO*");
                System.out.println("              ****************************");
                em.getTransaction().begin();
                //Ingresando a la tabla que voy a usar
                em.persist(l2);
                //Confirmar operacion
                em.getTransaction().commit();
            } else {
                System.out.println("*************************************");
                System.out.println("*El ISBN ya esta asignado a un LIBRO*");
                System.out.println("*************************************");
            }
        } catch (Exception e) {
            throw e;
        }
    }
//Metodo Buscar libro
    //9) Búsqueda de un libro por ISBN.

    public Libro buscarLibroIsbn(Long isbn) {

        try {
            return l1 = em.find(Libro.class, isbn);
        } catch (Exception e) {
            throw e;
        }
    }
    //Metodo Modificar  

    public void modificarLibro(String titulo) {

        try {
            Libro libro = em.find(Libro.class, 5L);
            System.out.print("->");
            libro.setTitulo(titulo);
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarLibro() {

        try {
            Libro libro = buscarLibroIsbn(leer.nextLong());
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }

    }
    //10) Búsqueda de un libro por Título. 

    public List buscarAutor(String Autor) {

        try {

            return aux2 = em.createQuery("Select a from libro a join autor where b.nombre like:nombre")
                    .setParameter("nombre", Autor).getResultList();

        } catch (Exception e) {
            throw e;
        }

    }

    public List buscarEditorial(String Autor) {

        try {

            return aux2 = em.createQuery("Select a from libro a join editorial e where e.nombre like:nombre")
                    .setParameter("nombre", Autor).getResultList();

        } catch (Exception e) {
            throw e;
        }

    }

}
