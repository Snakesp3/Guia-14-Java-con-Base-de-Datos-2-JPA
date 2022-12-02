

package Servicio;

import Entidades.Cliente;
import static Entidades.Cliente_.id;
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

    Cliente c1 = new Cliente();
    List<Cliente>clientes=new ArrayList();
    /*Servicioautor a1 = new Servicioautor();
    Servicioeditorial e1 = new Servicioeditorial();
    List<Libro> aux2 = new ArrayList();*/
    
     public void crearCliente() {

        try {
            System.out.println("");
            System.out.println("             ***********************************");
            System.out.println("             ***INGRESE LOS DATOS DEL CLIENTE***");
            System.out.println("             ***********************************");
            System.out.println("");
            System.out.println("***************************");
            System.out.println("*Ingrese el ID del cliente*");
            System.out.println("***************************");
            System.out.print("->");int id = leer.nextInt();
            if (buscarClienteId(id) == null) {
                Cliente c2 = new Cliente();
                
                c2.setId(id);
                System.out.println("*******************");
                System.out.println("*Ingrese el D.N.I*");
                System.out.println("*******************");
                System.out.print("->");c2.setDocumento(leer.nextLong());
                System.out.println("*******************");
                System.out.println("*Ingrese el Nombre*");
                System.out.println("*******************");
                System.out.print("->");c2.setNombre(leer.next());
                System.out.println("*********************");
                System.out.println("*Ingrese el Apellido*");
                System.out.println("*********************");
                System.out.print("->");c2.setApellido(leer.next());
                System.out.println("*********************");
                System.out.println("*Ingrese el telefono*");
                System.out.println("*********************");
                System.out.print("->");c2.setTelefono(leer.next());
                
                System.out.println("              *****************************");
                System.out.println("              *GRACIAS POR CREAR AL CLIENTE*");
                System.out.println("              *****************************");
                
                em.getTransaction().begin();
                //Ingresando a la tabla que voy a usar
                em.persist(c2);
                //Confirmar operacion
                em.getTransaction().commit();
            } else {
                System.out.println("*************************************");
                System.out.println("*El ID ya esta asignado a un Cliente*");
                System.out.println("*************************************");
                System.out.println("Cliente: " +c1.getNombre()+"\nApellido: "+c1.getApellido()+"\nID: "+ c1.getId());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public Cliente buscarClienteId(int id) {

        try {
            return c1 = em.find(Cliente.class, id);
        } catch (Exception e) {
            throw e;
        }
    }
    
     //Metodo Modificar  

    public void modificarCliente(Integer id) {

        try {
            Cliente cliente = em.find(Cliente.class, id);
            System.out.print("->");
            System.out.println("Ingrese el nuevo Nombre");
            cliente.setNombre(leer.next());
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            System.out.println("El nombre se modifico correctamente");
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarLibro() {

        try {
            System.out.print("->"); Cliente cliente = buscarClienteId(leer.nextInt());
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();

        } catch (Exception e) {
            throw e;
        }

    }
    
    public List buscarClientes (){
        
        try {
            return clientes = em.createQuery("SELECT c FROM Cliente c ").getResultList();
        } catch (Exception e) {
            throw e;
        }
        
        
    }
    
    
}
