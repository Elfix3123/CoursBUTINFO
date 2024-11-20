<?php
$ctrl = $_POST['submit'] ?? '';
$login = $_POST['login'] ?? '';
$password = $_POST['password'] ?? '';

switch ($ctrl) {
	case '':
		require("view/login.html");
		break;
	
	case 'login':
		session_start();
		$_SESSION['login'] = $login;
		require("view/main.php");
		break;
	
	case 'forgot':
		require("view/not_implemented.html");
		break;

	case 'new':
		require("view/not_implemented.html");
		break;
	
	default:
		$error = 'Mauvais controleur :"'.$ctrl.'"';
		exit(0);
}
?>
