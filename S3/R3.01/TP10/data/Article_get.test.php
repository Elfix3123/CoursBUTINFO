<?php
// Test de la classe Article
// Lancer le test en mode shell par : php Article.test.php
require_once("Article_get.class.php");

// Crée un nouvel article
$article = new Article("68733560","Coffret de douilles 91 pièces",79.90);

// Modificaiton de l'objet
$article->quantite = 5;

// Affichage de cet objet
printf("Article : %s\n",$article->libelle);
printf("Prix TTC : %s\n",$article->montant_TTC);
printf("Quantité : %s\n",$article->quantite);
 ?>
