<?php
// Controleur pour l'action sur les articles
// 
// Inclusion du framework
include_once("framework/view.fw.php");
// Inclusion du modèle
include_once("model/article.class.php");
// Nom du répertoire ou stocker les images téléchargées
$imgPath = "/public/img/";

$imgPath = "/home/felix/public/";

$error = [];
$message = "";

$ref = $_GET['ref'] ?? 0;

if (!$ref) {
	$error[] = "La référence doit etre non nulle.";
}

if (!sizeof($error)) {
	try {
		$article = article::read($ref);
	} catch (Exception $e) {
		$error[] = "Article non trouvé";
	}
	if ($article) {
		$message = "Ref : ".$article->getRef().", Libelle : ".$article->getLibelle().", Categorie : ".$article->getCategorie()->getNom().", Prix : ".$article->getPrix().", Image : ".$article->getImage();
	}
}

$view = new View();
$view->assign('ref',$ref);
$view->assign('error',$error);
$view->assign('message',$message);
$view->display('article.read'); 
?>
