
package main;

import Servicio.Servicioautor;
import Servicio.Servicioeditorial;
import Servicio.Serviciolibro;




public class PablitoMain {

    public static void main(String[] args) {
      
       Servicioautor a1 = new Servicioautor();
       
       Servicioeditorial e1 = new Servicioeditorial ();
       
       Serviciolibro l1 = new Serviciolibro ();
       
       //a1.crearAutor();
        System.out.println("-----------------------------------");
       a1.modificarAutor("CARLOSTEVEZ");
      // e1.crearEditorial();
       
       // l1.crearLibro();
       
       //l1.modificarLibro("Argentina2Mexico0");
       
        //l1.eliminarLibro();
        
        //a1.eliminarAutor();
       
       // e1.eliminarEditorial();
        
        
        
    }
      
}

