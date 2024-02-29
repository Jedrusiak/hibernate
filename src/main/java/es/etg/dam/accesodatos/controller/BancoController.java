package es.etg.dam.accesodatos.controller;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import es.etg.dam.accesodatos.view.ViewController;
import es.etg.dam.accesodatos.view.ViewFile;
import es.etg.dam.accesodatos.App;
import es.etg.dam.accesodatos.model.Cuenta;
import es.etg.dam.accesodatos.model.Usuario;
import es.etg.dam.accesodatos.model.basedatos.BancoDAO;
import es.etg.dam.accesodatos.model.basedatos.DAOFactory;

import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BancoController extends Application {
    private Usuario user;
    private Cuenta cuentaSeleccionada;
    private static SessionFactory sessionFactory;

    public Cuenta getCuentaSeleccionada() {
        return cuentaSeleccionada;
    }

    public void setCuentaSeleccionada(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }

    private List<Cuenta> cuentas;
    
    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    private BancoDAO daoBanco;

    private static Stage currentStage;

    public BancoController(){
        //Hola jefe, aqui eliges la base de datos que quieres utilizar, lo voy a dejar en modo 1 que es el modo MySQL
        // Pero tambien tiene el modo 0 que es SQLite
        daoBanco = DAOFactory.getDAO(2);
        configureHibernate();
    }

    @Override
    public void start(Stage stage) throws Exception {
        currentStage = stage;
        cargarVista(ViewFile.VIEW_INICIO);
        daoBanco.crearBBDD();
        daoBanco.crearTablas();
    }
    public void cargarVista(String ficheroView) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(ficheroView));
        Parent root = fxmlLoader.load();
        ViewController viewController = fxmlLoader.getController();
        viewController.setBancoController(this);
        Scene scene = new Scene(root);
        currentStage.close();
        currentStage.setScene(scene);
        currentStage.show();
    }
    private static void configureHibernate() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al inicializar la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public boolean iniciarSesion(String DNI, String contrasena) throws SQLException{
        return daoBanco.iniciarSesion(DNI, contrasena);
    }
    public String registrarse(Usuario usuario) throws SQLException{
        return daoBanco.registrarse(usuario);
    }
    public Usuario obtenerUsuario(String DNI, String contrasena) throws SQLException{
        return daoBanco.obtenerUsuario(DNI, contrasena);
    }
    public String crearCuenta(Usuario usuario) throws SQLException{
        return daoBanco.crearCuenta(usuario);
    }
    public List<Cuenta> obtenerCuentas(Usuario usuario) throws SQLException{
        return daoBanco.obtenerCuentas(usuario);
    }
    public void ingresar(Usuario usuario, int idCuenta, double cantidad) throws SQLException{
        daoBanco.ingresar(usuario, idCuenta, cantidad);
    }
    public void retirar(Usuario usuario, int id, double cantidad) throws SQLException{
        daoBanco.retirar(usuario, id, cantidad);
    }
    public String hacerBizum(String cuentaRemitente, double cantidad, String cuentaDestinatario) throws SQLException{
        return daoBanco.hacerBizum(cuentaRemitente, cantidad, cuentaDestinatario);
    }
    public Cuenta obtenerCuenta(int id) throws SQLException{
        return daoBanco.obtenerCuenta(id);
    }
    public double obtenerSaldo(int idCuenta) throws SQLException{
        return daoBanco.obtenerSaldo(idCuenta);
    }
    public String obtenerNombre(String telefono) throws SQLException{
        return daoBanco.obtenerNombre(telefono);
    }
}

