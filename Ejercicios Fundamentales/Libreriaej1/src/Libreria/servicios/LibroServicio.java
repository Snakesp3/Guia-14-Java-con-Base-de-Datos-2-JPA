
package Libreria.servicios;

import Libreria.entidades.Autor;
import Libreria.entidades.Editorial;
import Libreria.entidades.Libro;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibroServicio {

    Scanner leer = new Scanner(System.in);
    EntityManagerFactory em = Persistence.createEntityManagerFactory("LibreriaJPA");
    EntityManager emf = em.createEntityManager();
    Libro L1 = new Libro();
    Editorial e1 = new Editorial();
    Autor a1 = new Autor();
    EditorialServicio ed1 = new EditorialServicio();
    AutorServicio at1 = new AutorServicio();

    public void crearLibro() {
        
        try {
            L1.setIsbn(25085L);
            L1.setTitulo("Los muchachosdeEGG");
            L1.setAnio(2006);
            L1.setEjemplares(50);
            L1.setEjemplaresPrestados(5);
            L1.setEjemplaresRestantes(L1.getEjemplares() - L1.getEjemplaresPrestados());
            L1.setAlta(true);
            L1.setEditorial(ed1.buscarEditorialId(1));
            L1.setAutor(at1.buscarAutorId(123));
            
            emf.getTransaction().begin();
            emf.persist(L1);
            emf.getTransaction().commit();
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
    public Libro buscarIsbn(Long isbn) {
        
        try {
            return L1 = emf.find(Libro.class, isbn);            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificarLibro() {
        
        try {
            System.out.println("ingrese el ISBN del libro a modificar");
            Libro l2 = buscarIsbn(leer.nextLong());
            System.out.println("ingrese el año a modificar");
            l2.setAnio(leer.nextInt());
            emf.getTransaction().begin();
            emf.merge(l2);
            emf.getTransaction().commit();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarLibro() {
        
        try {
            System.out.println("ingrese el ISBN del libro a eliminar");
            Libro l2 = buscarIsbn(leer.nextLong());
            
            emf.getTransaction().begin();
            emf.remove(l2);
            emf.getTransaction().commit();
            
        } catch (Exception e) {
            throw e;
        }
        
    }
    
}
