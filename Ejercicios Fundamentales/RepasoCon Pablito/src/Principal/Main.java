package Principal;

import Entidades.Autor;
import Servicio.Servicioautor;
import Servicio.Servicioeditorial;
import Servicio.Serviciolibro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        Serviciolibro l1 = new Serviciolibro();
        Servicioautor a1 = new Servicioautor();
        Servicioeditorial e1 = new Servicioeditorial();

       
        
        int Libro;
        String volver = "s";
       
        do {
        System.out.println("****************");
        System.out.println("*Crear Libreria*");
        System.out.println("****************");
        System.out.println("<<<<OPCIONES>>>>");
        System.out.println("1) Crear Libro");
        System.out.println("2) Crear Autor");
        System.out.println("3) Crear Editorial");
        System.out.println("4) Salir");
        Libro = leer.nextInt();
            switch (Libro) {

                case 1:
                    l1.crearLibro();
                    break;
                case 2:
                    a1.crearAutor();
                    break;
                case 3:
                    e1.crearEditorial();
                    break;
                case 4:
                    System.out.println("**Gracias por participar**");
                    break;
                   
                default:
                    System.out.println("Elija la opcion del 1 al 3");
                    break;
               }
        } while (Libro!=4);

    }
}

