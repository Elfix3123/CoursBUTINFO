package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class TP3_Exo2Controller {
	@FXML
	public TextField tfNom;
	@FXML
	public TextField tfPrenom;
	@FXML
	public TextField tfLogin;
	@FXML
	public PasswordField pfMdP;
	@FXML
	public Button btnReset;
	@FXML
	public Button btnVerifier;
	@FXML
	public Button btnQuitter;
	@FXML
	public TextArea taCachee;

	@FXML
	public void reset(ActionEvent event) {
		System.out.println("Reset");
		tfNom.setText("");
		tfLogin.setText("");
		tfPrenom.setText("");
		pfMdP.setText("");
	}

	@FXML
	public void loginUpdate(KeyEvent event) {
		System.out.println("Login");
		tfLogin.setText(tfNom.getText().toLowerCase().substring(0, Math.min(tfNom.getText().length(), 7)) + tfPrenom.getText().toLowerCase().substring(0, Math.min(tfPrenom.getText().length(), 1)));
	}

	@FXML
	public void verifInfo(ActionEvent event) {
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
	
	@FXML
	public void closeWindow(ActionEvent event) {
		System.out.println("Close");
		Platform.exit();
	}

	@FXML
	public void showTextAera(MouseEvent event) {
		System.out.println("Show text aera");
		taCachee.setText("Nom : " + tfNom.getText() + 
		"\nPrenom : " + tfPrenom.getText() +
		"\nLogin : " + tfLogin.getText() + 
		"\nMdp : " + pfMdP.getText());
	}

	@FXML
	public void hideTextAera(MouseEvent event) {
		System.out.println("Hide text aera");
		taCachee.setText("Passez la souris ici !");
	}
}