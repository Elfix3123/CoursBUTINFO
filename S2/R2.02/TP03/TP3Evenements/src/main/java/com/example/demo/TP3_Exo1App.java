package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import org.controlsfx.control.action.Action;

public class TP3_Exo1App extends Application {
	@Override
	public void start(Stage stage) throws IOException {

		stage.setTitle("Infos");
		VBox vbox = new VBox();
		vbox.setPrefWidth(350);
		vbox.setPrefHeight(300);

		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(0, 20, 20, 20));
		gridPane.setAlignment(Pos.CENTER);


		Label labelNom = new Label("Nom : ");
		Label labelPrenom = new Label("Prénom : ");
		Label labelLogin = new Label("Login : ");
		Label labelMdP = new Label("Mot de passe : ");

		TextField tfNom = new TextField();
		TextField tfPrenom = new TextField();
		TextField tfLogin = new TextField();
		tfLogin.setEditable(false);
		PasswordField pfMdP = new PasswordField();

		gridPane.add(labelNom, 0, 0);
		gridPane.add(labelPrenom, 0, 1);
		gridPane.add(labelLogin, 0, 2);
		gridPane.add(labelMdP, 0, 3);

		gridPane.add(tfNom, 1, 0);
		gridPane.add(tfPrenom, 1, 1);
		gridPane.add(tfLogin, 1, 2);
		gridPane.add(pfMdP, 1, 3);


		Button btnReset = new Button("Reset");
		Button btnVerifier = new Button("Vérifier");
		Button btnQuitter = new Button("Quitter");

		HBox hboxBoutons = new HBox();
		hboxBoutons.setSpacing(30);
		hboxBoutons.setAlignment(Pos.CENTER);
		hboxBoutons.setPadding(new Insets(0,0,20,0));
		hboxBoutons.getChildren().addAll(btnReset, btnVerifier, btnQuitter);

		TextArea taCachee = new TextArea("Passez la souris ici !");
		taCachee.setEditable(false);

		//Ajoutez vos gestionnaires d'évènements
		btnReset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Reset");
				tfNom.setText("");
				tfLogin.setText("");
				tfPrenom.setText("");
				pfMdP.setText("");
			}
		});

		EventHandler<KeyEvent> loginUpdate = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("Login");
				tfLogin.setText(tfNom.getText().toLowerCase().substring(0, Math.min(tfNom.getText().length(), 7)) + tfPrenom.getText().toLowerCase().substring(0, Math.min(tfPrenom.getText().length(), 1)));
			}
		};

		tfNom.setOnKeyTyped(loginUpdate);
		tfPrenom.setOnKeyTyped(loginUpdate);

		EventHandler<ActionEvent> verifInfo = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Verif");
				if (tfNom.getText().isEmpty()) {
					tfNom.setStyle("-fx-border-color: red");
				}
				else {
					tfNom.setStyle("-fx-border-color: none");
				}
				if (tfPrenom.getText().isEmpty()) {
					tfPrenom.setStyle("-fx-border-color: red");
				}
				else {
					tfPrenom.setStyle("-fx-border-color: none");
				}
				if (pfMdP.getText().length() < 8) {
					pfMdP.setStyle("-fx-border-color: red");
				}
				else {
					pfMdP.setStyle("-fx-border-color: none");
				}
			}
		};

		btnVerifier.setOnAction(verifInfo);

		EventHandler<ActionEvent> closeWindow = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Close");
				stage.close();
			}
		};

		btnQuitter.setOnAction(closeWindow);

		EventHandler<MouseEvent> showTextAera = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Show text aera");
				taCachee.setText("Nom : " + tfNom.getText() + 
				"\nPrenom : " + tfPrenom.getText() +
				"\nLogin : " + tfLogin.getText() + 
				"\nMdp : " + pfMdP.getText());
			}
		};

		taCachee.setOnMouseEntered(showTextAera);

		EventHandler<MouseEvent> hideTextAera = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				System.out.println("Hide text aera");
				taCachee.setText("Passez la souris ici !");
			}
		};

		taCachee.setOnMouseExited(hideTextAera);

		vbox.getChildren().addAll(gridPane, hboxBoutons, taCachee);
		vbox.setPadding(new Insets(10,10,10,10));

		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}


