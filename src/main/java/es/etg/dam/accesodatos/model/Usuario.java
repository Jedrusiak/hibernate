package es.etg.dam.accesodatos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @Column(name = "DNI", length = 50)
    private String dni;

    @Column(name = "NOMBRE", length = 20)
    private String nombre;

    @Column(name = "CONTRASENA", length = 15)
    private String contrasena;

    @Column(name = "TELEFONO", length = 40)
    private String telefono;

    // Constructor, getters, setters, etc.

    // Constructor
    public Usuario() {
        // Empty constructor required by Hibernate
    }

    // Getters and setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
