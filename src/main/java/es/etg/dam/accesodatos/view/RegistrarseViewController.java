package es.etg.dam.accesodatos.view;

import java.io.IOException;
import java.sql.SQLException;

import es.etg.dam.accesodatos.model.Cuenta;
import es.etg.dam.accesodatos.model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegistrarseViewController extends ViewController {

    @FXML
    private Button btnRegistrarse;

    @FXML
    private TextField tfContrasena;

    @FXML
    private TextField tfDNI;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTelefono;

    @FXML
    void registrarse(MouseEvent event) throws SQLException {
        String DNI = tfDNI.getText();
        String nombre = tfNombre.getText();
        String contrasena = tfContrasena.getText();
        String telefono = tfTelefono.getText();

        Usuario usuario = new Usuario(DNI, nombre, contrasena, telefono);
        Cuenta cuenta = new Cuenta(0, 0, DNI);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(bancoController.registrarse(usuario));

        alert.showAndWait();

    }

    @FXML
    void backear(MouseEvent event) throws IOException, SQLException {
        bancoController.cargarVista(ViewFile.VIEW_INICIO);
    }
}
