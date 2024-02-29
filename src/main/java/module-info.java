module es.etg.dam.accesodatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.naming;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires transitive java.sql;
    requires java.desktop;

    opens es.etg.dam.accesodatos to javafx.fxml;
    opens es.etg.dam.accesodatos.controller to javafx.fxml, java.sql;
    opens es.etg.dam.accesodatos.model to javafx.fxml, java.sql;
    opens es.etg.dam.accesodatos.view to javafx.fxml, java.sql;
    exports es.etg.dam.accesodatos;
    exports es.etg.dam.accesodatos.controller;
    exports es.etg.dam.accesodatos.model;
    exports es.etg.dam.accesodatos.view;
}
