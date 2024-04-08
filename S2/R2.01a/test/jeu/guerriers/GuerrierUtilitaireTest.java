package test.jeu.guerriers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jeu.guerriers.GuerrierUtilitaire;

public class GuerrierUtilitaireTest {
	@Test
	void testDe3() {
		int resultatDe;
		int i = 0;

		while (i < 100) {
			resultatDe = GuerrierUtilitaire.de3();
			Assertions.assertTrue(1 <= resultatDe & resultatDe <= 3, "Le résultat du dé devrait être entre 1 et 3");
			i++;
		}
	}

	@Test
	void testDe3Arg() {
		int resultatDe;
		int i = 0;

		while (i < 100) {
			resultatDe = GuerrierUtilitaire.de3(100);
			Assertions.assertTrue(100 <= resultatDe & resultatDe <= 300, "Le résultat du dé devrait être entre 1 et 3");
			i++;
		}
	}
}
