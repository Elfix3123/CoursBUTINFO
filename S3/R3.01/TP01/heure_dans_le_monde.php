<?php
$villes = array('America/Anchorage','America/Los_Angeles','America/Guadeloupe',
'Europe/Paris', 'Africa/Kigali',
'Asia/Singapore','Australia/Sydney','Pacific/Auckland');
?>
<!DOCTYPE html>
<html lang="fr">
<?php  header("refresh: 60"); ?>
<head>
	<meta charset="utf-8">
	<title>L'heure dans le monde</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>L'heure dans le monde</h1>
	<table>
		<?php
		foreach ($villes as $value) {
			date_default_timezone_set($value);
			print("<tr><td>$value</td><td>" . date("h:m d/m/Y") ."</td></tr>");
		}
		?>
	</table>
</body>
</html>
