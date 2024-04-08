package test.jeu.elements;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jeu.elements.Chateau;
import jeu.elements.Couleur;
import jeu.elements.Plateau;
import jeu.guerriers.Guerrier;
import jeu.guerriers.Nain;

public class PlateauTest {
	@Test
	void testAjoutGuerriers() {
		ArrayList<Guerrier> guerriersBleus = new ArrayList<>();
		Chateau chateauBleu = new Chateau(Couleur.BLEU);

		int i = 0;

		while (i < 10) {
			guerriersBleus.add(new Nain());
			i++;
		}

		Plateau plateau = new Plateau(5);
		plateau.ajoutGuerriers(chateauBleu, guerriersBleus);

		Assertions.assertEquals(10, plateau.getCaseDepartBleus().getGuerriersBleus().size(), "Le nombre de guerriers ajoutés doit être égal à 10");
	}

	@Test
	void testDeplacerGuerriers() {
		ArrayList<Guerrier> guerriersBleus = new ArrayList<>();
		Chateau chateauBleu = new Chateau(Couleur.BLEU);
		guerriersBleus.add(new Nain());

		ArrayList<Guerrier> guerriersRouges = new ArrayList<>();
		Chateau chateauRouge = new Chateau(Couleur.BLEU);
		guerriersRouges.add(new Nain());

		Plateau plateau = new Plateau(5);
		plateau.ajoutGuerriers(chateauBleu, guerriersBleus);
		plateau.ajoutGuerriers(chateauRouge, guerriersRouges);

		plateau.deplacerGuerriers();

		Assertions.assertTrue(plateau.getCaseDepartBleus().getGuerriersBleus().isEmpty(), "Il ne doit plus y avoir de guerriers bleus sur la case de départ des bleus");

		plateau.deplacerGuerriers();
		plateau.deplacerGuerriers();
		plateau.deplacerGuerriers();
		plateau.deplacerGuerriers();

		Assertions.assertTrue(plateau.getCaseDepartBleus().getGuerriersBleus().isEmpty() & plateau.getCaseDepartBleus().getGuerriersRouges().isEmpty(), "Aucun guerrier ne dois être arrivé au bout du plateau");
	}
}
