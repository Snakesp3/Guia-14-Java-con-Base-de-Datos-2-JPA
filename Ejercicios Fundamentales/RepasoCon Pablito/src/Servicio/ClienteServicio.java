

package Servicio;

import Entidades.Prestamos;
import Entidades.Libro;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ClienteServicio {
   
     /*Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para
     administrar autores (consulta, creación, modificación y eliminación).*/
    
    //Metodo que usa la unidad de persistencia para manejar los datos
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RepasoPablito");

    //intermediario entre el programa y base de datos
    EntityManager em = emf.createEntityManager();

    Scanner leer = new Scanner(System.in);

    Prestamos c1 = new Prestamos();

    /*Servicioautor a1 = new Servicioautor();
    Servicioeditorial e1 = new Servicioeditorial();
    List<Libro> aux2 = new ArrayList();*/
    
     public void crearLibro() {

        try {
            System.out.println("");
            System.out.println("             *******************************************");
            System.out.println("             ***INGRESE LOS DATOS DEL CLIENTE A CREAR***");
            System.out.println("             *******************************************");
            System.out.println("");
            System.out.println("<<<Ingrese el ISBN>>>");
            System.out.print("->");Long isbn = leer.nextLong();
            if (buscarLibroIsbn(isbn) == null) {
                Libro l2 = new Libro();
                
                l2.setIsbn(isbn);
                System.out.println("*******************");
                System.out.println("*Ingrese el Titulo*");
                System.out.println("*******************");
                System.out.print("->");l2.setTitulo(leer.next());
                System.out.println("****************");
                System.out.println("*Ingrese el Año*");
                System.out.println("****************");
                System.out.print("->");l2.setAnio(leer.nextInt());
                System.out.println("************************");
                System.out.println("*Cantidad de Ejemplares*");
                System.out.println("************************");
                System.out.print("->");l2.setEjemplares(leer.nextInt());
                System.out.println("**********************************");
                System.out.println("*Cantidad de Ejemplares Prestados*");
                System.out.println("**********************************");
                System.out.print("->");l2.setEjemplaresPrestados(leer.nextInt());
                l2.setEjemplaresRestantes(l2.getEjemplares() - l2.getEjemplaresPrestados());
                System.out.println("*************************");
                System.out.println("*Ingrese el Id del Autor*");
                System.out.println("*************************");
                System.out.print("->");l2.setAutor(a1.buscarAutorId(leer.nextInt()));
                System.out.println("*******************************");
                System.out.println("*Ingrese el Id de la Editorial*");
                System.out.println("*******************************");
                System.out.print("->");l2.setEditorial(e1.buscarEditorialid(leer.nextLong()));
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
    
    
    
    
    
    
}
