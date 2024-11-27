<?php
// 
// Inclusion du framework
include_once("framework/view.fw.php");

session_start();
$_SESSION['login'] = $_POST['login'] ?? "";
$_SESSION['password'] = $_POST['password'] ?? "";
$_SESSION['connected'] = $_SESSION['password'] and $_SESSION['login'];

////////////////////////////////////////////////////////////////////////////
// Construction de la vue
////////////////////////////////////////////////////////////////////////////
$view = new View();

if ($_SESSION['connected']) {
  $view->assign('title', 'Vous êtes connecté');
  $view->assign('message','Vous pouvez utiliser les boutons du menu.');
} else {
  $view->assign('title', "Vous n'êtes pas connecté.");
  $view->assign('message','Vous devez vous logger.');
}
$view->display('message');
?>