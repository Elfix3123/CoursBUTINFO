package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller {
	@FXML private GridPane grid;
	@FXML private Button btnEnd;
	@FXML private Label label;
	boolean fin = false;
	private Morpion morpion = new Morpion();

	public void initialize() {
		int i = 0;
		for (Node node : grid.getChildren()) {
			Button button = (Button) node;
			final int index = i;
			button.setOnAction(e -> onSquareClicked(index));
			i++;
		}
		label.setText("Au tour du joueur " + (morpion.getJoueurCourant() == 0 ? "X" : "O"));
	}

	public void loadNamesScreen() {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("names.fxml"));
	
			// Associer le controleur courant
			fxmlLoader.setController(this);
	
			Parent sceneDialog = fxmlLoader.load();
			// v1 :Scene sceneDialog = new Scene(fxmlLoader.load(), 300, 275);
			// v1 Stage dialog = (Stage) btnValider.getScene().getWindow();
			Stage dialog = new Stage();
			// v2
			dialog.setScene(new Scene(sceneDialog));
			// v1 : dialog.setScene(sceneDialog);
	
			dialog.show();
		}
	
		catch(Exception e) {e.printStackTrace();}
	}

	private void onSquareClicked(int b) {
		Button button = (Button)grid.getChildren().get(b);
		button.setText(morpion.getJoueurCourant() == 0 ? "X" : "O");
		button.setDisable(true);
		fin = morpion.jouer(b);

		if (fin & morpion.getCasesLibres() != 0) {
			for (Node node : grid.getChildren()) {
				button = (Button) node;
				button.setDisable(true);
			}
			label.setText("Le joueur " + (morpion.getJoueurCourant() == 0 ? "X" : "O") + " a gagné !");
		}
		else if (fin) {
			label.setText("Match nul !");
		}
		else {
			label.setText("Au tour du joueur " + (morpion.getJoueurCourant() == 0 ? "X" : "O"));
		}
	}

	@FXML
	public void onEndButtonClicked(ActionEvent event) {
		for (Node node : grid.getChildren()) {
			Button button = (Button) node;
			button.setDisable(false);
			button.setText("");
		}
		morpion = new Morpion();
		label.setText("Au tour du joueur " + (morpion.getJoueurCourant() == 0 ? "X" : "O"));
	}
}
