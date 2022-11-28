package Servicio;

import Entidades.Libro;
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

    public void crearLibro() {
        try {
            System.out.println("");
            System.out.println("              *****************************************");
            System.out.println("              ***INGRESE LOS DATOS DEL LIBRO A CREAR***");
            System.out.println("              *****************************************");
            System.out.println("");
            System.out.println("<<<Ingrese el ISBN>>>");
            System.out.print("->");l1.setIsbn(leer.nextLong());
            System.out.println("*********************");
            System.out.println("<<<Ingrese el Titulo>>>");
            System.out.print("->");l1.setTitulo(leer.next());
            System.out.println("***********************");
            System.out.println("<<<Ingrese el Año>>>");
            System.out.print("->");l1.setAnio(leer.nextInt());
            System.out.println("********************");
            System.out.println("<<<Cantidad de Ejemplares>>>");
            System.out.print("->");l1.setEjemplares(leer.nextInt());
            System.out.println("****************************");
            System.out.println("<<<Cantidad de Ejemplares Prestados>>>");
            System.out.print("->");l1.setEjemplaresPrestados(leer.nextInt());
            System.out.println("**************************************");
            l1.setEjemplaresRestantes(l1.getEjemplares() - l1.getEjemplaresPrestados());
            System.out.println("<<<Ingrese el Id del Autor>>>");
            System.out.print("->");l1.setAutor(a1.buscarAutorId(leer.nextInt()));
            System.out.println("*****************************");
            System.out.println("<<<Ingrese el Id de la Editorial>>>");
            System.out.print("->");l1.setEditorial(e1.buscarEditorialid(leer.nextInt()));
            System.out.println("***********************************");

            em.getTransaction().begin();
            //Ingresando a la tabla que voy a usar
            em.persist(l1);
            //Confirmar operacion
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        }
    }
//Metodo Buscar libro

    public Libro buscarLibroIsbn(Long isbn) {

        try {
            return l1 = em.find(Libro.class, isbn);
        } catch (Exception e) {
            throw e;
        }
    }
}
