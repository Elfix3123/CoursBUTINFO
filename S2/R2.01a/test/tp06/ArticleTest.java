package test.tp06;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import tp06.Article;
import tp06.IntituleVideException;
import tp06.PrixInvalideException;
import tp06.StockInvalideException;

public class ArticleTest {
	@Test
	public void testGetIntitule() throws IntituleVideException, PrixInvalideException {
		//
		Article article1 = new Article("minuscule", 2.0, 10);
		Assertions.assertEquals(article1.getIntitule(), "Minuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");
		//
		Article article2 = new Article("MAJUSCULE", 2.0, 10);
		Assertions.assertEquals(article2.getIntitule(), "Majuscule", "Un intitulé doit avoir la première lettre en Majuscule et le reste en minuscule");
	}

	@Test
	public void testSetIntitule() throws IntituleVideException, PrixInvalideException {
		//
		Assertions.assertThrows(IntituleVideException.class, () -> {new Article(null, 2.0, 10);}, "Un intitulé ne peut pas être null.");
		//
		Assertions.assertThrows(IntituleVideException.class, () -> {
			new Article("", 2.0, 10);
		}, "Un intitulé ne peut pas être vide.");
	}

	@org.junit.jupiter.api.Test
	void testExistQuantite() {
		Article article1 = new Article("Label", 2.0, 10);
		Assertions.assertTrue(article1.existQuantite(5), "La méthode doit renvoyer si la quantité précisée est en stock");
		Assertions.assertFalse(article1.existQuantite(15), "La méthode doit renvoyer si la quantité précisée est en stock");
	}

	@org.junit.jupiter.api.Test
	void testGetPrix() {
		Article article1 = new Article("Label", 2.0, 10);
		Assertions.assertEquals(article1.getPrix(), 2.0, "Le prix doit être le même que celui initialisé");
	}

	@org.junit.jupiter.api.Test
	void testGetStock() {
		Article article1 = new Article("Label", 2.0, 10);
		Assertions.assertEquals(article1.getStock(), 10, "Le stock doit être le même que celui initialisé");
	}

	@org.junit.jupiter.api.Test
	void testRemoveQuantite() {
		Article article1 = new Article("Label", 2.0, 10);
		article1.removeQuantite(5);
		Assertions.assertEquals(article1.getStock(), 5, "Le stock doit être de 5 après avoir retiré 5");
		Assertions.assertThrows(StockInvalideException.class, () -> {article1.removeQuantite(10);}, "La méthode doit renvoyer une erreur");
	}

	@org.junit.jupiter.api.Test
	void testSetPrix() {
		Article article1 = new Article("Label", 2.0, 10);
		article1.setPrix(3.0);
		Assertions.assertEquals(article1.getPrix(), 3.0, "Le prix doit être de 3.0 après avoir modifié le prix");
		Assertions.assertThrows(PrixInvalideException.class, () -> {article1.setPrix(-1.0);}, "La méthode doit renvoyer une erreur");	
	}

	@org.junit.jupiter.api.Test
	void testSetStock() {
		Article article1 = new Article("Label", 2.0, 10);
		article1.setStock(5);
		Assertions.assertEquals(article1.getStock(), 5, "Le stock doit être de 5 après avoir modifié le stock");
		Assertions.assertThrows(StockInvalideException.class, () -> {article1.setStock(-5);}, "La méthode doit renvoyer une erreur");	
	
	}
}