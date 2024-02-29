package es.etg.dam.accesodatos.model;

import javax.persistence.*;

@Entity
@Table(name = "CUENTAS")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "SALDO")
    private float saldo;

    @ManyToOne
    @JoinColumn(name = "DNIPROPIETARIO", referencedColumnName = "DNI")
    private Usuario dniPropietario;

    @Column(name = "TELEFONO", length = 255)
    private String telefono;

    // Constructor, getters, setters, etc.

    // Constructor
    public Cuenta() {
        // Constructor vacío requerido por Hibernate
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Usuario getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(Usuario dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

