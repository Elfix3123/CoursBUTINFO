package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	@FXML private TextField tfResult;
	@FXML private TextArea taHistory;
	private Calculatrice calculatrice = new Calculatrice();

	@FXML
	public void buttonZeroPressed(ActionEvent event) {
		if (calculatrice.setOperande(0)) {
			tfResult.setText(tfResult.getText() + "0");
		}
	}

	@FXML
	public void buttonOnePressed(ActionEvent event) {
		if (calculatrice.setOperande(1)) {
			tfResult.setText(tfResult.getText() + "1");
		}
	}

	@FXML
	public void buttonOrPressed(ActionEvent event) {
		if (calculatrice.setOperation("ou")) {
			tfResult.setText(tfResult.getText() + "|");
		}
	}

	@FXML
	public void buttonAndPressed(ActionEvent event) {
		if (calculatrice.setOperation("et")) {
			tfResult.setText(tfResult.getText() + "&");
		}		
	}

	@FXML
	public void buttonXorPressed(ActionEvent event) {
		if (calculatrice.setOperation("xou")) {
			tfResult.setText(tfResult.getText() + "^");
		}
	}

	@FXML
	public void buttonEqualsPressed(ActionEvent event) {
		int resultat = calculatrice.getResultat();
		taHistory.setText(taHistory.getText() + tfResult.getText() + "=" + resultat + "\n");
		if (resultat != -1) {
			calculatrice.setOperande(resultat);
			tfResult.setText(Integer.toString(resultat));
		}
	}

	@FXML
	public void buttonResetPressed(ActionEvent event) {
		calculatrice.reset();
		tfResult.setText("");
	}
}
