<?php
// Réaction à tous les boutons du menu
// 
// Inclusion du framework
include_once('framework/view.fw.php');
// Inclusion du modèle
include_once('model/article.class.php');

$viewName = $_GET['viewName'] ?? 'main';

include_once('controler/' . $viewName . '.ctrl.php');