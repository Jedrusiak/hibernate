package es.etg.dam.accesodatos.view;
import es.etg.dam.accesodatos.controller.BancoController;

public class ViewController {
    protected BancoController bancoController;

    public void setBancoController(BancoController controller){
        this.bancoController = controller;
    }
}
