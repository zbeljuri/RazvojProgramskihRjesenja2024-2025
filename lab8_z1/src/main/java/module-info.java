module com.example.eb_z2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.eb_z2 to javafx.fxml;
    opens com.example.eb_z2.controller to javafx.fxml; // Open the controller package
    exports com.example.eb_z2;
}