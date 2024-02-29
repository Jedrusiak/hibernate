package es.etg.dam.accesodatos.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.etg.dam.accesodatos.model.Cuenta;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

public class MenuViewController extends ViewController {

    @FXML
    private Button btnCrearCuenta;

    @FXML
    private Button btnHacerBizum;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRetirar;

    @FXML
    private Label lblNOMBRE;

    @FXML
    private Label lblID;

    @FXML
    private Label lblCantidad;

    @FXML
    public void initialize() throws Exception {
        Platform.runLater(() -> {
            actualizarValores();
        });
    }

    @FXML
    void crearCuenta(MouseEvent event) throws SQLException {
        // Crear un cuadro de diálogo de confirmación
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText("¿Estás seguro de que quieres crear una nueva cuenta?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Si el usuario confirma, crear la cuenta
            bancoController.crearCuenta(bancoController.getUser());
            bancoController.setCuentas(bancoController.obtenerCuentas(bancoController.getUser()));
        } else {
            // Si el usuario cancela, no hacer nada
        }
    }

    @FXML
    void hacerBizum(MouseEvent event) {
        // Cuadro de diálogo para la cantidad
        TextInputDialog dialogCantidad = new TextInputDialog();
        dialogCantidad.setTitle("Ingreso de dinero");
        dialogCantidad.setHeaderText(null);
        dialogCantidad.setContentText("Por favor, introduce la cantidad de dinero que quieres ingresar:");

        Optional<String> resultCantidad = dialogCantidad.showAndWait();

        // Cuadro de diálogo para el teléfono
        TextInputDialog dialogTelefono = new TextInputDialog();
        dialogTelefono.setTitle("Número de teléfono");
        dialogTelefono.setHeaderText(null);
        dialogTelefono.setContentText("Por favor, introduce el número de teléfono:");

        Optional<String> resultTelefono = dialogTelefono.showAndWait();

        resultCantidad.ifPresent(cantidadStr -> {
            double cantidad = Double.parseDouble(cantidadStr);

            resultTelefono.ifPresent(telefono -> {
                // Cuadro de diálogo de confirmación
                Alert alertConfirmacion = new Alert(Alert.AlertType.CONFIRMATION);
                alertConfirmacion.setTitle("Confirmación");
                alertConfirmacion.setHeaderText(null);
                try {
                    alertConfirmacion
                            .setContentText("Le vas a hacer un bizum a: " + bancoController.obtenerNombre(telefono)
                                    + "\n" + "¿Estás seguro de que quieres realizar esta operación?");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                Optional<ButtonType> resultConfirmacion = alertConfirmacion.showAndWait();
                if (resultConfirmacion.get() == ButtonType.OK) {
                    // Si el usuario confirma, realiza la operación Bizum
                    try {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Información");
                        alert.setHeaderText(null);
                        alert.setContentText(bancoController.hacerBizum(
                                bancoController.getCuentaSeleccionada().getTelefono(), cantidad,
                                telefono));

                        alert.showAndWait();
                        actualizarValores();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        });
    }

    @FXML
    void ingresar(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ingreso de dinero");
        dialog.setHeaderText(null);
        dialog.setContentText("Por favor, introduce la cantidad de dinero que quieres ingresar:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(cantidadStr -> {
            double cantidad = Double.parseDouble(cantidadStr);

            try {
                bancoController.ingresar(bancoController.getUser(), bancoController.getCuentaSeleccionada().getId(),
                        cantidad);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            actualizarValores();
        });
    }

    @FXML
    void retirar(MouseEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Retirada de dinero");
        dialog.setHeaderText(null);
        dialog.setContentText("Por favor, introduce la cantidad de dinero que quieres retirar:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(cantidadStr -> {
            double cantidad = Double.parseDouble(cantidadStr);

            try {
                bancoController.retirar(bancoController.getUser(), bancoController.getCuentaSeleccionada().getId(),
                        cantidad);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            actualizarValores();
        });
    }

    @FXML
    void cambiarCuenta(MouseEvent event) {
        List<Integer> choices = new ArrayList<>();
        for (Cuenta cuenta : bancoController.getCuentas()) {
            choices.add(cuenta.getId());
        }
        ChoiceDialog<Integer> dialog = new ChoiceDialog<>(null, choices);
        dialog.setTitle("Seleccionar cuenta");
        dialog.setHeaderText(null);
        dialog.setContentText("Por favor, selecciona el ID de la cuenta:");

        Optional<Integer> result = dialog.showAndWait();
        result.ifPresent(idCuenta -> {
            try {
                bancoController.setCuentaSeleccionada(bancoController.obtenerCuenta(idCuenta));
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if (bancoController.getCuentaSeleccionada().getTelefono() == null) {
                btnHacerBizum.setDisable(true);
            } else {
                btnHacerBizum.setDisable(false);
            }
            lblID.setText(String.valueOf(bancoController.getCuentaSeleccionada().getId()));
            lblCantidad.setText(String.valueOf(bancoController.getCuentaSeleccionada().getSaldo()));
        });
    }

    private void actualizarValores() {
        try {
            lblNOMBRE.setText(bancoController.getUser().getNombre() + "!");
            lblID.setText(String.valueOf(bancoController.getCuentaSeleccionada().getId()));
            lblCantidad.setText(
                    String.valueOf(bancoController.obtenerSaldo(bancoController.getCuentaSeleccionada().getId())));
            if (bancoController.getCuentaSeleccionada().getTelefono() == null) {
                btnHacerBizum.setDisable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backear(MouseEvent event) throws IOException, SQLException {
        bancoController.cargarVista(ViewFile.VIEW_INICIO);
    }
}
