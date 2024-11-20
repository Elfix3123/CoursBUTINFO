<?php
// 
// Inclusion du framework
include_once('framework/view.fw.php');
// Inclusion du modèle
include_once('model/article.class.php');
include_once('model/categorie.class.php');


// 
///////////////////////////////////////////////////////
// A COMPLETER
///////////////////////////////////////////////////////

// Numero de page
$page = $_GET['page'] ?? 1;
$pagesize = $_GET['pagesize'] ?? 12;
// Pas de filtrage par catégorie
$idCategorie = $_GET['idCategorie'] ?? 1;
$categorie = categorie::read($idCategorie);
$articles = $idCategorie == 1 ? article::readPage($page, $pagesize) : article::readPageCategorie($page, $pagesize, $categorie);

////////////////////////////////////////////////////////////////////////////
// Construction de la vue
////////////////////////////////////////////////////////////////////////////
$view = new View();

// Passe les paramètres à la vue
$view->assign('categorie', $categorie);
$view->assign('articles', $articles);
$view->assign('page', $page);
$view->assign('pagesize', $pagesize);
// Charge la vue
$view->display("articles")
?>
