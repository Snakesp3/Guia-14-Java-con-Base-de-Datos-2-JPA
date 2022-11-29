package Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Editorial {

    @Id
    private Integer id;
    private String nombre;
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(Integer id, String nombre, Boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
