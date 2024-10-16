<?php
include(__DIR__. "/data/PSQLrequests.php");

// récupère les informations de la query string
$city = $_GET['city'] ?? 'Dallas';

// Open PSQL connexion
$db = openConnection();
?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" href="design/style.css">
		<title>My contacts from <?= $city ?></title>
	</head>
	<body>
		<h1>My contacts from <?= $city ?></h1>
		<table>
			<tr>
				<th>Name</th>
				<th>Phone</th>
			</tr>
			<?php foreach (askdb($db, "SELECT name, phone FROM contact WHERE city = '$city';") as $contact): ?>
				<tr>
					<td><?=$contact["name"]?></td>
					<td><?=$contact["phone"]?></td>
				</tr>
			<?php endforeach?>
		</table>
	</body>
</html>
