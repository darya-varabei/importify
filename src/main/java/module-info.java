module com.example.importify {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires AnimateFX;

    opens com.example.importify to javafx.fxml;
    exports com.example.importify;
    exports com.example.importify.Controller;
    opens com.example.importify.Controller to javafx.fxml;
    exports com.example.importify.Model;
    opens com.example.importify.Model to javafx.base;
}