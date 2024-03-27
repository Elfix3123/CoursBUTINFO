package test.jeu.elements;

import org.junit.jupiter.api.Test;

import elements.Carreau;
import guerriers.Guerrier;
import guerriers.Nain;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

public class CarreauTest {
	@Test
	void testLanceCombat() {
		ArrayList<Guerrier> lesNainsBleus = new ArrayList<>();
		for (int i; i < 10; i++) {
			lesNainsBleus.add(new Nain());
		}
		ArrayList<Guerrier> lesNainsRouges = new ArrayList<>();
		for (int i; i < 10; i++) {
			lesNainsBleus.add(new Nain());
		}
		Carreau carreau = new Carreau();
		carreau.ajoutGuerriersBleus(lesNainsBleus);
		carreau.ajoutGuerriersRouges(lesNainsRouges);

		carreau.lanceCombat();
		Assertions.assertTrue(carreau.getGuerriersBleus().get(0).getPointsDeVie() < 100, "Le guerrier doit avoir perdu de la vie");
	}

	@Test
	void testSupprimerGuerrier() {
		Nain nain = new Nain();
		ArrayList<Guerrier> lesNains = new ArrayList<>();
		lesNains.add(nain);
		Carreau carreau = new Carreau();
		carreau.ajoutGuerriersBleus(lesNains);

		carreau.supprimerGuerrier(nain);
		Assertions.assertTrue(carreau.getGuerriersBleus().isEmpty(), "Le guerrier doit être supprimé");
	}
}
