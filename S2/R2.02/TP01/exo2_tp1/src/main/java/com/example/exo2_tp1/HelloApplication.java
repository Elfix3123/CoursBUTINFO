package com.example.exo2_tp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Exo 2");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("tp1.css").toExternalForm());
    }

    public static void main(String[] args) {
        launch();
    }
}