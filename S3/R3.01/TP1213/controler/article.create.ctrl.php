<?php
// Controleur pour l'action sur les articles
// 
// Inclusion du framework
include_once("framework/view.fw.php");
// Inclusion du modèle
include_once("model/article.class.php");
// Nom du répertoire ou stocker les images téléchargées
$imgPath = "/home/felix/public/";

$error = [];
$message = "";

$ref = $_POST['ref'] ?? 0;
$libelle = $_POST['libelle'] ?? "";
$categorie = $_POST['categorie'] ?? 0;
$prix = $_POST['prix'] ?? 0;
$image = $_FILES['image'] ?? 0;

if (!$ref) {
	$error[] = "La référence doit etre non nulle.";
}
if (!$libelle) {
	$error[] = "Le libelle doit etre non vide.";
}
if (!$categorie) {
	$error[] = "La categorie doit etre non nulle.";
}
if (!$prix) {
	$error[] = "Le prix doit etre non nul.";
}
if (!$image['name']) {
	$error[] = "Il faut indiquer le nom du fichier.";
}
if (!$image['size']) {
	$error[] = "La taille du fichier doit etre non nulle.";
}
if ($image['error'] == 4) {
	$error[] = "L'erreur 4 a ete detectee lors du transfert de l'image.";
}
if ($image['type'] != "image/jpeg" and $image['type'] != "image/png") {
	$error[] = "L'image doit etre de type JPEG ou PNG";
}

if (!sizeof($error)) {
	move_uploaded_file($image['tmp_name'], $imgPath . basename($image['name']));
	$article = new Article($ref, $libelle, categorie::read($categorie), $prix, "/".$image['name']);
	$article->create();
	$message = "Insertion reussie";
}

$view = new View();
$view->assign('ref',$ref);
$view->assign('libelle',$libelle);
$view->assign('categorie',$categorie);
$view->assign('prix',$prix);
$view->assign('image',$image['name']);
$view->assign('error',$error);
$view->assign('message',$message);
$view->display('article.create');
?>
