package Servicio;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Servicioeditorial {

    //Metodo que usa la unidad de persistencia para manejar los datos
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RepasoPablito");

//intermediario entre el programa y base de datos
    EntityManager em = emf.createEntityManager();

    Scanner leer = new Scanner(System.in);

    Editorial edi = new Editorial();

    public void crearEditorial() {
        try {
            System.out.println("ingrese los datos de la editorial a crear");
            Integer idi = leer.nextInt();
            if (buscarEditorialid(idi)==null) {
             System.out.println("Ingrese el Id");
            edi.setId(idi);
            System.out.println("Ingrese el nombre de la Editorial");
            edi.setNombre(leer.next());

            edi.setAlta(true);
            em.getTransaction().begin();
            em.persist(edi);
            em.getTransaction().commit();  
            }else{
                System.out.println("Esta Editorial ya EXITE!");
            }   
            
        } catch (InputMismatchException e) {
            throw e;
        }

    }

    public Editorial buscarEditorialid(int id) {

        try {

            return edi = em.find(Editorial.class, id);

        } catch (Exception e) {
            throw e;
        }

    }
     public  void modificarEditorial(String nombre){
        
        try {
            Editorial editorial= em.find(Editorial.class, 5L);
            System.out.println("<<<Modificar el Titulo del libro>>>");
            System.out.print("->"); editorial.setNombre(nombre);
            em.getTransaction().begin();
            em.merge(nombre);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
     public  void eliminarEditorial(){
        
        try {
            Editorial editorial= em.find(Editorial.class, 5);
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
            throw e;
        }
        
        
    }
}
