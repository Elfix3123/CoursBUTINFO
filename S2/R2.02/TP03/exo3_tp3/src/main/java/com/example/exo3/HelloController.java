package com.example.exo3;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HelloController {

    @FXML
    public Button btnValider, btnAnnuler, btnConfirmQuit, btnCancelQuit;
    @FXML
    public Label labelRes;
    @FXML
    public TextField fieldNom, fieldPrenom;
    @FXML
    public TextField fieldRes;

    @FXML
    public void onValiderButtonPressed(ActionEvent event)  throws Exception {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("affichage.fxml"));

        // Associer le controleur courant v1
        fxmlLoader.setController(this);

        Parent sceneDialog = fxmlLoader.load();
        // v1 :Scene sceneDialog = new Scene(fxmlLoader.load(), 300, 275);
        // v1 Stage dialog = (Stage) btnValider.getScene().getWindow();
            Stage dialog = new Stage();
        // v2
            dialog.setScene(new Scene(sceneDialog));
       // v1 : dialog.setScene(sceneDialog);

        dialog.show();

        fieldRes.setText(fieldNom.getText()+ " " + fieldPrenom.getText());

    } catch(Exception e) {e.printStackTrace();}
    }


    @FXML
    protected void onAnnulerButtonPressed() throws Exception{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("confirm.fxml"));

            // Associer le controleur courant v1
            fxmlLoader.setController(this);

            Parent sceneDialog = fxmlLoader.load();
            // v1 :Scene sceneDialog = new Scene(fxmlLoader.load(), 300, 275);
            // v1 Stage dialog = (Stage) btnValider.getScene().getWindow();
            Stage dialog = new Stage();
            // v2
            dialog.setScene(new Scene(sceneDialog));
            // v1 : dialog.setScene(sceneDialog);

            dialog.show();


        } catch(Exception e) {e.printStackTrace();}

        //Platform.exit();
    }

    @FXML
    protected void onOuiButtonPressed() {
        Platform.exit();
    }

    @FXML
    protected void onNonButtonPressed() {
        Stage stage = (Stage) btnCancelQuit.getScene().getWindow();
        stage.close();
    }
}