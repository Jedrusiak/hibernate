package es.etg.dam.accesodatos.model.basedatos;

import java.sql.SQLException;
import java.util.List;

import es.etg.dam.accesodatos.model.Cuenta;
import es.etg.dam.accesodatos.model.Usuario;

public interface BancoDAO {
    public void crearBBDD();
    public void crearTablas() throws SQLException;
    public void ingresar(Usuario usuario, int idCuenta, double cantidad) throws SQLException;
    public void retirar(Usuario usuario, int id, double cantidad) throws SQLException;
    public String hacerBizum(String cuentaRemitente, double cantidad, String cuentaDestinatario) throws SQLException;
    public String registrarse(Usuario usuario) throws SQLException;
    public boolean iniciarSesion(String DNI, String contrasena) throws SQLException;
    public Usuario obtenerUsuario(String DNI, String contrasena) throws SQLException;
    public Cuenta obtenerCuenta(int id) throws SQLException;
    public String crearCuenta(Usuario usuario) throws SQLException;
    public List<Cuenta> obtenerCuentas(Usuario usuario) throws SQLException;
    public double obtenerSaldo(int idCuenta) throws SQLException;
    public Cuenta obtenerCuenta(String telefono) throws SQLException;
    public String obtenerNombre(String telefono) throws SQLException;
}

