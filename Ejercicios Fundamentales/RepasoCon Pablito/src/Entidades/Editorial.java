package Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Editorial {

    @Id
    private Long id;
    private String nombre;
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(Long id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id != null) {
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        }
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        if (alta != null) {
            this.alta = alta;
        }
    }

}
