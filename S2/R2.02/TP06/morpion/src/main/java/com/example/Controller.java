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

	public void Initialise() {
		for (Node node : grid.getChildren()) {
			Button button = (Button) node;
			System.out.println(GridPane.getRowIndex(button) * 3 + GridPane.getColumnIndex(button));
			button.setOnAction(e -> onSquareClicked(GridPane.getRowIndex(button) * 3 + GridPane.getColumnIndex(button)));
		}
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

		buttons.get(b).setText(morpion.getJoueurCourant() == 0 ? "X" : "O");
		buttons.get(b).setDisable(true);
		fin = morpion.jouer(b);

		if (fin) {
			for (Button button : buttons) {
				button.setDisable(true);
			}
			label.setText("Le joueur " + (morpion.getJoueurCourant() == 0 ? "X" : "O") + " a gagné !");
		}
	}

	@FXML
	public void onEndButtonClicked(ActionEvent event) {
		System.out.println(buttons);
		System.out.println(buttons.get(0));
	}
}
