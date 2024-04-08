package test.jeu.guerriers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jeu.guerriers.ChefElfe;
import jeu.guerriers.ChefNain;
import jeu.guerriers.Elfe;
import jeu.guerriers.Nain;

public class GuerrierTest {
	@Test
	void testAttaquer() {
		Elfe elfe = new Elfe();
		Nain nain = new Nain();
		ChefElfe chefElfe = new ChefElfe();
		elfe.attaquer(nain);
		Assertions.assertTrue(70 <= nain.getPointsDeVie() & nain.getPointsDeVie() <= 90, "Les points de vie du nain devraient être entre 70 et 90");
		chefElfe.attaquer(nain);
		Assertions.assertTrue(10 <= nain.getPointsDeVie() & nain.getPointsDeVie() <= 70, "Les points de vie du nain devraient être entre 10 et 70");
	}

	@Test
	void testGetForce() {
		Nain nain = new Nain();
		ChefNain chefNain = new ChefNain();
		Elfe elfe = new Elfe();
		ChefElfe chefElfe = new ChefElfe();
		Assertions.assertEquals(10, nain.getForce(), "La force du nain devrait être de 10");
		Assertions.assertEquals(10, chefNain.getForce(), "La force du chef nain devrait être de 10");
		Assertions.assertEquals(20, elfe.getForce(), "La force de l'elfe devrait être de 20");
		Assertions.assertEquals(40, chefElfe.getForce(), "La force du chef elfe devrait être de 40");
	}

	@Test
	void testGetRessourcesPourEntrainement() {
		Nain nain = new Nain();
		ChefNain chefNain = new ChefNain();
		Elfe elfe = new Elfe();
		ChefElfe chefElfe = new ChefElfe();
		Assertions.assertEquals(1, nain.getRessourcesPourEntrainement(), "Les ressources pour l'entraînement du nain devraient être de 1");
		Assertions.assertEquals(3, chefNain.getRessourcesPourEntrainement(), "Les ressources pour l'entraînement du chef nain devraient être de 3");
		Assertions.assertEquals(2, elfe.getRessourcesPourEntrainement(), "Les ressources pour l'entraînement de l'elfe devraient être de 2");
		Assertions.assertEquals(4, chefElfe.getRessourcesPourEntrainement(), "Les ressources pour l'entraînement du chef elfe devraient être de 4");
	}
}
