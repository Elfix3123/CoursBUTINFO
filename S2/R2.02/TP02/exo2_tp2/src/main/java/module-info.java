module com.example.exo2_tp1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.exo2_tp2 to javafx.fxml;
    exports com.example.exo2_tp2;
}