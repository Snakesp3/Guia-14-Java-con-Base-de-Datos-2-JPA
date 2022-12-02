package Principal;

import Entidades.Autor;
import Servicio.ClienteServicio;
import Servicio.Servicioautor;
import Servicio.Servicioeditorial;
import Servicio.Serviciolibro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

//        Serviciolibro l1 = new Serviciolibro();
//        Servicioautor a1 = new Servicioautor();
//        Servicioeditorial e1 = new Servicioeditorial();

          ClienteServicio cl = new ClienteServicio();
          
          //cl.crearCliente();
          cl.modificarCliente(2);
//
//       
//        
//        int Libro;
//        do {
//        System.out.println("");
//        System.out.println("//////////////*******************///////////////");
//        System.out.println("//////////////*OPCIONES DE CARGA*///////////////");
//        System.out.println("//////////////*******************///////////////");
//        System.out.println("---ELIJA UNA OPCION DEL 1 AL 3 O 4 PARA SALIR---");
//        System.out.println("================================================");
//        System.out.println("          * * * * * * * * * * * * * *");
//        System.out.println("          *   1) Crear Libro        *");
//        System.out.println("          *                         *");
//        System.out.println("          *   2) Crear Autor        *");
//        System.out.println("          *                         *");
//        System.out.println("          *   3) Crear Editorial    *");
//        System.out.println("          *                         *");
//        System.out.println("          *   4) Salir              *");
//        System.out.println("          * * * * * * * * * * * * * *");
//        System.out.print("->");Libro = leer.nextInt();
//            switch (Libro) {
//
//                case 1:
//                    l1.crearLibro();
//                    break;
//                case 2:
//                    a1.crearAutor();
//                    break;
//                case 3:
//                    e1.crearEditorial();
//                    break;
//                case 4:
//                    System.out.println("***GRACIAS POR SUMINISTRAR LA INFORMACION A LA BASE DE DATOS***");
//                    break;
//                   
//                default:
//                    System.out.println("*****************************");
//                    System.out.println("*ELIJA UNA OPCION DEL 1 al 4*");
//                    System.out.println("*****************************");
//                    break;
//               }
//        } while (Libro!=4);

    }
}

