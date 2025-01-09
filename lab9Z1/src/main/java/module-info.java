module com.example.lab9Z1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.lab9Z1.controller to javafx.fxml;
    exports com.example.lab9Z1;
}