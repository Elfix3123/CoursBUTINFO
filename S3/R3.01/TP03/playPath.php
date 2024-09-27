<?php
// Récupération des valeurs
$music = $_GET['music'] ?? 0;
$infos = explode('/', $music);
?>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>&#x1F399; Mon jukebox static</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header>
	<h1>Ma musique dans mon Jukebox</h1>
	</header>
	<main>
		<section>
			<figure>
				<img src="data/<?=$music?>.jpeg" />
				<figcaption>
					<audio src="data/<?=$music?>.mp3" controls="" autoplay=""></audio>
					<music-song><?=$infos[1]?></music-song>
					<music-group><?=$infos[0]?></music-group>
				</figcaption>
			</figure>
		</section>
	</main>
	<footer>
	</footer>
	</body>
</html>
