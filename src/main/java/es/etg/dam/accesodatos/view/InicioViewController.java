package es.etg.dam.accesodatos.view;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InicioViewController extends ViewController{

    @FXML
    private Label lblRegistrarse;

    @FXML
    private TextField tfContrasena;

    @FXML
    private TextField tfUsuario;

    @FXML
    void acceder(MouseEvent event) {
        try{
            String DNI = tfUsuario.getText();
            String contrasena = tfContrasena.getText();
    
            if (bancoController.iniciarSesion(DNI, contrasena) == true){
                // verifica si el usuario existe, y setea valores de cuentas y user en el controlador, y setea la cuentaSeleccionada en el controlador (la default)
                bancoController.setUser(bancoController.obtenerUsuario(DNI, contrasena));
                bancoController.setCuentaSeleccionada(bancoController.obtenerCuentas(bancoController.getUser()).get(0));
                bancoController.setCuentas(bancoController.obtenerCuentas(bancoController.getUser()));
                bancoController.cargarVista(ViewFile.VIEW_MENU);
            }
            }catch (Exception e){

            }
    }

    @FXML
    void registrarse(MouseEvent event) throws IOException, SQLException {
        bancoController.cargarVista(ViewFile.VIEW_REGISTRARSE);
    }

}
