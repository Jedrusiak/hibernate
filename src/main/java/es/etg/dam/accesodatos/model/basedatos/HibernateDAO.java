package es.etg.dam.accesodatos.model.basedatos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import es.etg.dam.accesodatos.model.Cuenta;
import es.etg.dam.accesodatos.model.Usuario;

public class HibernateDAO implements BancoDAO {
    private final SessionFactory sessionFactory;
    
    public HibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void crearBBDD() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearBBDD'");
    }

    @Override
    public void crearTablas() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearTablas'");
    }

    @Override
    public void ingresar(Usuario usuario, int idCuenta, double cantidad) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ingresar'");
    }

    @Override
    public void retirar(Usuario usuario, int id, double cantidad) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retirar'");
    }

    @Override
    public String hacerBizum(String cuentaRemitente, double cantidad, String cuentaDestinatario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hacerBizum'");
    }

    @Override
    public String registrarse(Usuario usuario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registrarse'");
    }

    @Override
    public boolean iniciarSesion(String DNI, String contrasena) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iniciarSesion'");
    }

    @Override
    public Usuario obtenerUsuario(String DNI, String contrasena) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerUsuario'");
    }

    @Override
    public Cuenta obtenerCuenta(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCuenta'");
    }

    @Override
    public String crearCuenta(Usuario usuario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearCuenta'");
    }

    @Override
    public List<Cuenta> obtenerCuentas(Usuario usuario) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCuentas'");
    }

    @Override
    public double obtenerSaldo(int idCuenta) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerSaldo'");
    }

    @Override
    public Cuenta obtenerCuenta(String telefono) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerCuenta'");
    }

    @Override
    public String obtenerNombre(String telefono) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNombre'");
    }
    
}