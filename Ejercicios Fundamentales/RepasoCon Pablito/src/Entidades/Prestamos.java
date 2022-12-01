
package Entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Prestamos {
 @Id   
    
   private Integer id;
   private Date fechaPrestamo;
   private Date fechaDevolicion;
   @OneToOne
   private Libro libro;
   @OneToOne
   private Prestamos cliente;

    public Prestamos() {
    }

    public Prestamos(Integer id, Date fechaPrestamo, Date fechaDevolicion, Libro libro, Prestamos cliente) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolicion = fechaDevolicion;
        this.libro = libro;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolicion() {
        return fechaDevolicion;
    }

    public void setFechaDevolicion(Date fechaDevolicion) {
        this.fechaDevolicion = fechaDevolicion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Prestamos getCliente() {
        return cliente;
    }

    public void setCliente(Prestamos cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
    
}
