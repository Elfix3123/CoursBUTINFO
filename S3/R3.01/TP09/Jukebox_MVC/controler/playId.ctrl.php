<?php
// Joue une musique conneu par son Id
// Inclusion du modèle
require_once('model/music.class.php');
require_once('model/dao.class.php');
// Inclusion du fw
require_once('framework/view.fw.php');

$id = $_GET['id'] ;
$music = Music::read($id);

$view = new View();
$view->assign('music', $music);
$view->display('playId');
?>
