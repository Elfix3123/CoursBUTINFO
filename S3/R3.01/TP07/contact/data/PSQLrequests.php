<?php
function openConnection() : PDO {
	$db = new PDO('pgsql:host=localhost;port=5432;dbname=phppdo;user=phppdo;password=phppdo') or die();
	return $db;
}

function askdb(PDO $db, string $query) : array {
	$requete = $db->prepare($query) or die();
	$requete->execute();
	return $requete->fetchall();
}
?>
