package tp06;

/**
 * Cette classe vise à implémenter un article d'un site d'e-commerce.
 */
public class Article {
	private String intitule;
	private double prix;
	private int stock;
	private final int SEUIL = 100;

	/**
	 * Constructeur d'une instance d'Article.
	 * 
	 * @param intitule
	 * @param prix
	 * @param stock
	 */
	public Article(String intitule, double prix, int stock) {
		if (stock <= 0) {
			throw new StockInvalideException("Le stock ne peux pas être nul ou négatif à l'enregistrement d'un article");
		}
		this.setIntitule(intitule);
		this.setPrix(prix);
		this.setStock(stock);
	}

	/**
	 * Retourne l'intitulé de l'article.
	 * 
	 * @return l'intitulé de l'article.
	 */
	public String getIntitule() {
		return this.intitule;
	}

	/**
	 * Modifie l'intitulé de l'article.
	 * 
	 * @param intitule
	 */
	public void setIntitule(String intitule) {
		if (intitule == null || intitule.isEmpty()) {
			throw new IntituleVideException("L'intitulé ne peux pas être vide");
		}
		this.intitule = ArticleUtilitaire.capitalize(intitule);
	}

	/**
	 * Retourne le prix de l'article.
	 * 
	 * @return le prix de l'article.
	 */
	public double getPrix() {
		return this.prix;
	}

	/**
	 * Retourne le prix de l'article en fonction d'une quantité en paramètre.
	 * 
	 * @param quantite
	 * 
	 * @return le prix de l'article en fonction d'une quantité en paramètre.
	 */
	public double getPrix(int quantite) {
		if (quantite >= this.SEUIL) {
			return this.prix * quantite * 0.9;
		}
		else {
			return this.prix * quantite;
		}
	}

	/**
	 * Modifie le prix de l'article.
	 * 
	 * @param prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
		if (this.prix <= 0) {
			throw new PrixInvalideException("Le prix ne peux pas être nul");
		}
	}

	/**
	 * Retourne le stock de l'article.
	 * 
	 * @return le stock de l'article.
	 */
	public int getStock() {
		return this.stock;
	}

	/**
	 * Modifie le stock de l'article.
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
		if (this.stock < 0) {
			throw new StockInvalideException("Le stock ne peux pas être négatif");
		}
	}

	/**
	 * Retourne vrai si l'article est en stock pour la quantité en paramètre, faux sinon.
	 * 
	 * @return booleen
	 */
	public boolean existQuantite(int quantite) {
		return this.stock >= quantite;
	}

	/**
	 * Enlève une quantité en paramètre du stock de l'article.
	 * 
	 * @param quantite
	 */
	public void removeQuantite(int quantite) {
		if (this.stock < quantite) {
			throw new StockInvalideException("Le stock ne peux pas être négatif");
		}
		this.stock -= quantite;
	}
}
