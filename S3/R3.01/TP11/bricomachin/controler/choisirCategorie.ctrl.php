<?php
// 
// Inclusion du framework
include_once('framework/view.fw.php');
// Inclusion du modèle
include_once('model/article.class.php');
include_once('model/categorie.class.php');

$idCategorie = $_GET['idCategorie'] ?? 1;
$categorie = categorie::read($idCategorie);
$subCategories = $categorie->readSubCategorie();

////////////////////////////////////////////////////////////////////////////
// Construction de la vue
////////////////////////////////////////////////////////////////////////////
$view = new View();

if (!$subCategories) {
	include("controler/afficherArticles.ctrl.php");
}
else {
	// Passe les paramètres à la vue
	$view->assign('categorie', $categorie);
	$view->assign('subCategories', $subCategories);
	// Charge la vue
	$view->display("categorie");
}
?>
