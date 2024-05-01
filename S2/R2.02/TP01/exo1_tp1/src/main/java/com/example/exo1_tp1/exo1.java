package com.example.exo1_tp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.ArrayList;

// extension de la classe Application pour créer une application JavaFX
public class exo1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Méthode d’initialisation de la scène
    public void start(Stage primaryStage) {
        // définition de la fenêtre (taille, et titre)
        primaryStage.setWidth(500);
        primaryStage.setHeight(300);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Fenêtre JavaFX");

        // définition d’un conteneur VBox qui arrange les sous-composants sur une seule colonne.
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        // définition d’un texte
        Text text = new Text("Exemple de Code Java pur");
        text.setFill(Color.BROWN);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));

        // Ajout du texte dans le conteneur vbox
        vbox.setMargin(text, new Insets(20, 50, 20, 50));
        vbox.getChildren().addAll(text);

        // Définition et ajout d'un textfield
        TextField textField = new TextField();
        vbox.getChildren().addAll(textField);

        // ajout de boutons radio
        ToggleGroup toggleGroup = new ToggleGroup();
        ArrayList<RadioButton> radios = new ArrayList<>();
        RadioButton r1 = new RadioButton("JavaFX");
        r1.setSelected(true);
        r1.setToggleGroup(toggleGroup);
        RadioButton r2 = new RadioButton("Swing");
        r2.setToggleGroup(toggleGroup);
        RadioButton r3 = new RadioButton("Autre");
        r3.setToggleGroup(toggleGroup);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(r1, r2, r3);
        vbox.setMargin(hbox, new Insets(20, 50, 20, 50));
        vbox.getChildren().addAll(hbox);

        // Ajout d’un bouton dans le conteneur vbox
        Button button = new Button("Compris !");
        vbox.getChildren().addAll(button);

        // spécification de la scène avec la Xbox
        primaryStage.setScene(new Scene(vbox));

        // rendre la fenêtre visible
        primaryStage.show();
    }
}
