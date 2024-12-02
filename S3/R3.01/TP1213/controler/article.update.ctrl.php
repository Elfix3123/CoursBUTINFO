<?php
// Controleur pour l'action sur les articles
// 
// Inclusion du framework
include_once('framework/view.fw.php');
// Inclusion du modèle
include_once('model/article.class.php');


$error = [];
$message = "";

$ref = $_GET['ref'] ?? 0;
$libelle = $_GET['libelle'] ?? "";
$categorie = $_GET['categorie'] ?? 0;
$prix = $_GET['prix'] ?? 0;
$image = $_FILES['image'] ?? 0;

if (isset($_GET['refresh'])) {
	if (!$ref) {
		$error[] = "La référence doit etre non nulle.";
	}

	if (!sizeof($error)) {
		$article = Article::read($ref);
		if ($article) {
			$ref = $article->getRef();
			$libelle = $article->getLibelle();
			$prix = $article->getPrix();
			$message = "Article trouvé et rafraichi";
		} else {
			$error[] = "Article non trouvé";
		}
	}
}
elseif (isset($_GET['update'])) {
	if (!$ref) {
		$error[] = "La référence doit etre non nulle.";
	}
	if (!$libelle) {
		$error[] = "Le libelle doit etre non vide.";
	}
	if (!$prix) {
		$error[] = "Le prix doit etre non nul.";
	}

	if (!sizeof($error)) {
		$article = article::read($ref);
		$article->setLibelle($libelle);
		$article->setPrix($prix);
		$article->update();
		$message = "Mise à jour reussie";
	}
}

$view = new View();
$view->assign('ref',$ref);
$view->assign('libelle',$libelle);
$view->assign('prix',$prix);
$view->assign('error',$error);
$view->assign('message',$message);
$view->display('article.update');
?>
