
package Libreria;

import Libreria.servicios.AutorServicio;
import Libreria.servicios.EditorialServicio;
import Libreria.servicios.LibroServicio;

public class Ej1JPA {

  
    public static void main(String[] args) {
      
        LibroServicio l1=new LibroServicio();
        AutorServicio a1=new AutorServicio();
        EditorialServicio e1=new EditorialServicio();
    //   a1.crearAutor();
       // e1.crearEditorial();
       l1.crearLibro();
      // l1.eliminarLibro();
    }
    
}
