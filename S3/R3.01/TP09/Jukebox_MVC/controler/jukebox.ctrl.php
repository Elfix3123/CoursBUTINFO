<?php
// Inclusion du modèle
require_once('model/music.class.php');
require_once('model/dao.class.php');
// Inclusion du fw
require_once('framework/view.fw.php');

$page = $_GET['page'] ?? 1;
$pagesize = $_GET['pagesize'] ?? 8;
$pagenb = ceil(Music::maxId()/$pagesize);

$view = new View();
$view->assign('page', $page);
$view->assign('pagesize', $pagesize);
$view->assign('pagenb', $pagenb);
$view->display('jukebox');
?>
