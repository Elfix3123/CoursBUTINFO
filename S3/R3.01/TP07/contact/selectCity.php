<?php
include(__DIR__. "/data/PSQLrequests.php");

// Open PSQL connexion
$db = openConnection();
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="design/style.css">
	<title>Select a city bbg</title>
</head>
<body>
<body>
	<h1>Select a city</h1>
		<form action="contact.php" method="GET">
			<table>
				<?php foreach (askdb($db, "SELECT DISTINCT city FROM contact;") as $city): ?>
					<tr>
						<td><input type="radio" id="<?=$city['city']?>" name="city" value="<?=$city['city']?>"></td>
						<td><label for="<?=$city['city']?>"><?=$city['city']?></label></td>
					</tr>
				<?php endforeach?>
			</table>
			<button type="submit">Send</button>
		</form>
	</body>
</body>
</html>