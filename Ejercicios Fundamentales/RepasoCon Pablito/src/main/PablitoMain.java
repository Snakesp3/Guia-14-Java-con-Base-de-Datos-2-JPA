package main;

import Servicio.Servicioautor;
import Servicio.Servicioeditorial;
import Servicio.Serviciolibro;

public class PablitoMain {

    public static void main(String[] args) {

        Servicioautor a1 = new Servicioautor();

        Servicioeditorial e1 = new Servicioeditorial();

        Serviciolibro l1 = new Serviciolibro();

        l1.crearLibro();
        a1.crearAutor();
        e1.crearEditorial();
        
        //a1.modificarAutor("Julio");
        

        //l1.modificarLibro("Argentina2Mexico0");
        //l1.eliminarLibro();
        //a1.eliminarAutor();
        // e1.eliminarEditorial();
        /* int answer;

        do {
            System.out.println("\n============= LIBRERIA =============\n");
            System.out.println("Que te gustaría hacer?");
            System.out.println("");
            System.out.println("1) Crear autor");
            System.out.println("2) ");
            System.out.println("3) ");
            System.out.println("4) ");
            System.out.println("5) Crear editorial");
            System.out.println("6) ");
            System.out.println(
            "
            System.out.println("7) ");
            System.out.println("8) Crear libro");
            System.out.println("9) ");
            System.out.println("10) ");
            System.out.println("11) ");
            System.out.println("12) ");
            System.out.println("13) ");
            System.out.println("14) ");
            System.out.println("15) Salir");
            answer = read.nextInt();

            switch (answer) {

                case 1:
                    a1.crearAutor();
                    break;
                     case 2:
                    a1.buscarAutor();
                    break;
                     case 3:
                    a1.modificarAutor();
                    break;
                      case 4:
                    a1.eliminarAutor();
                    break;

            }

        }*/
    }
}
