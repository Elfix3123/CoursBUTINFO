<?php
// Récupération de le controleur à activer 
// Par défaut on lance l'action main
$ctrl = $_GET['ctrl'] ?? 'jukebox';
// Liste des controleurs possibles
// Cette liste permet d'être sûr de ne pas charger de fichier inconnu
const CTRLS = ['jukebox', 'playId'];

// Vérification que l'action est correcte
if (! in_array($ctrl,CTRLS)) {
  // Ouvre une page d'erreur
  $error = 'Mauvais controleur :"'.$ctrl.'"';
  exit(0);
}
// Calcule le chemin vers le fichier du controleur
$path = 'controler/'.$ctrl.'.ctrl.php';
// Charge le controleur
require_once($path);
?>