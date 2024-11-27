<?php
require_once(__DIR__ . '/dao.class.php');
require_once(__DIR__ . '/categorie.class.php');

// Un article en vente 
class Article
{
	private int     $ref;         // Référence unique
	private string  $libelle;     // Nom de l'article
	private Categorie  $categorie; // La catégorie de cet attribut
	private float   $prix;        // Le prix
	private string  $image;       // Nom du fichier image
	// URL absolue pour les images
	const distantURL =  'https://www-info.iut2.univ-grenoble-alpes.fr/intranet/enseignements/ProgWeb/data/bricomachin/img/';
	const localURL = "public/img/";

	// Constructeur
	public function __construct(
		int $ref = -1,
		string $libelle = '',
		Categorie $categorie = NULL,
		float $prix = 0.0,
		string  $image = ''
	) {
		$this->ref = $ref;
		$this->libelle = $libelle;
		// On ne peux pas affecter NULL à un attribut de type Categorie
		if ($categorie === NULL) {
			$this->categorie = new Categorie();
		} else {
			$this->categorie = $categorie;
		}
		$this->prix = $prix;
		$this->image = $image;
	}

	// Getters
	public function getRef(): int
	{
		return $this->ref;
	}

	public function getLibelle(): string
	{
		return $this->libelle;
	}

	public function getCategorie(): Categorie
	{
		return $this->categorie;
	}

	public function getCategorieNom(): string
	{
		return $this->categorie->getNom();
	}

	public function getPrix(): float
	{
		return $this->prix;
	}

	public function getImage(): string
	{
		return $this->image;
	}

	// Retourne l'URL complete de l'image pour une utilisation dans la vue.
	public function getImageURL(): string
	{
		return $this->getImage()[0] == "/" ? article::localURL.$this->getImage() : article::distantURL.$this->getImage();
	}

	// Setter
	// NB: on n'a pas le droit de changer la référence car cela devient un autre objet

	public function setLibelle(string $libelle): void {
		$this->libelle = $libelle;
	}

	public function setPrix(float $prix): void {
		$this->prix = $prix;
	}

	// ////////////////////////////////////////////////////////////////////////////
	// Gestion de la persistance, Acces CRUD
	// CRUD = Create Read Update Delete
	//////////////////////////////////////////////////////////////////////////////

	// Retourne le nombre total d'articles dans la base
	// Est utilisé pour calculer le nombre de pages
	public static function count(int $id): int
	{
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $id == 1 ? $dao->prepare('SELECT count(*) FROM article') : $dao->prepare("SELECT count(*) FROM article WHERE categorie = $id");
		// Exécute la requête SQL en lui passant les paramètres
		$query->execute();
		// Récupère le résultat
		$table = $query->fetchAll();
		// Retourne le resultat
		$row = $table[0];
		return $row['count'];
	}



	/////////////////////////// CREATE /////////////////////////////////////


	// Création d'un nouvel article dans la base de données
	// Si le résultat de excec sur la base de donnée ne retourne pas 1
	// alors lève une exception pour signaler que l'insertion a échoué
	public function create()
	{
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $dao->prepare("INSERT INTO article VALUES(:ref, :libelle, :categorie, :prix, :image);");
		// Exécute la requête SQL
		try {
			$query->execute([':ref' => $this->getRef(), ':libelle' => $this->getLibelle(), ':categorie' => $this->getCategorie()->getId(), ':prix' => $this->getPrix(), ':image' => $this->getImage()]);
		} catch (Exception $e) {
			throw $e;
		}
	}

	////////////// READ /////////////////////////////////////////////

	// Acces à un article connaissant sa référence
	// $ref : la référence de l'article
	public static function read(int $ref): Article
	{
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $dao->prepare('SELECT * FROM article WHERE ref = :ref');
		// Exécute la requête SQL en lui passant les paramètres
		$query->execute([':ref' => $ref]);
		// Récupère le résultat
		$table = $query->fetchAll();
		// Il ne doit y avoir qu'un seul résultat dans la table
		if (count($table) == 0) {
			throw new Exception("Erreur:  Article $ref non trouvée");
		}
		// Il ne peux pas y avoir plus d'une instance avec cet ref
		if (count($table) > 1) {
			throw new Exception("Incohérence:  Article $ref existe en ".count($table)." exemplaires");
		}
		// Les données de cette catégorie
		$row = $table[0];
		// Crée l'instance
		$article = new Article($row['ref'], $row['libelle'], categorie::read($row['categorie']), $row['prix'], $row['image']);
		return $article;
	}

	// Récupère des articles étant donné un No de page
	// Les articles sont triés par No de référence
	// $page : le No de page qui débute à 1
	// $pageSize : le nombre de référence d'articles par pages
	public static function readPage(int $page, int $pageSize): array
	{
		$articlesPage = [];
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $dao->prepare('SELECT * FROM article ORDER BY ref LIMIT :limit OFFSET :offset;');
		// Exécute la requête SQL en lui passant les paramètres
		$query->execute([':limit' => $pageSize, ':offset' => ($page-1)*$pageSize]);
		// Récupère le résultat
		$table = $query->fetchAll();
		// Retourne le resultat
		
		foreach ($table as $row) {
			$articlesPage[] = new Article($row['ref'], $row['libelle'], categorie::read($row['categorie']), $row['prix'], $row['image']);
		}

		return $articlesPage;
	}

	// Récupère des articles étant donné un No de page et une catégorie
	// Les articles sont triés par No de référence
	// $page : le No de page qui débute à 1
	// $pageSize : le nombre de référence d'articles par pages
	// $categorie : la categorie qui sert de filtre
	public static function readPageCategorie(int $page, int $pageSize, Categorie $categorie): array
	{
		$articlesPage = [];
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $dao->prepare('SELECT * FROM article WHERE categorie = :catid ORDER BY ref LIMIT :limit OFFSET :offset;');
		// Exécute la requête SQL en lui passant les paramètres
		$query->execute([':limit' => $pageSize, ':offset' => ($page-1)*$pageSize, ':catid' => $categorie->getId()]);
		// Récupère le résultat
		$table = $query->fetchAll();
		// Retourne le resultat
		
		foreach ($table as $row) {
			$articlesPage[] = new Article($row['ref'], $row['libelle'], categorie::read($row['categorie']), $row['prix'], $row['image']);
		}

		return $articlesPage;
	}

	/////////////////////////// UPDATE /////////////////////////////////////

	// Mise à jour d'un article
	public function update()
	{
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $dao->prepare("UPDATE article SET (libelle, categorie, prix, image) = (:libelle, :categorie, :prix, :image) WHERE ref = :ref;");
		// Exécute la requête SQL
		try {
			$query->execute([':ref' => $this->getRef(), ':libelle' => $this->getLibelle(), ':categorie' => $this->getCategorie()->getId(), ':prix' => $this->getPrix(), ':image' => $this->getImage()]);
		} catch (Exception $e) {
			throw $e;
		}
	}

	/////////////////////////// DELETE /////////////////////////////////////

	// Suppression d'un article
	public function delete()
	{
		// Acces au DAO
		$dao = DAO::get();
		// Prépare la requête SQL
		$query = $dao->prepare("DELETE FROM article WHERE ref = :ref;");
		// Exécute la requête SQL
		try {
			$query->execute([':ref' => $this->getRef()]);
		} catch (Exception $e) {
			throw $e;
		}
	}
}
