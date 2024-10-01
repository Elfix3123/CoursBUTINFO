<?php
include('readDelimitedData.php');
// Lecture de toutes les musiques


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
		<?php $musics = readDelimitedData('jukeboxData.txt'); ?>
		<?php foreach ($musics as $value):?>
			<figure>
				<a href="playPath.php?music=<?=$value[0]?>/<?=$value[1]?>">
		 			<img src="data/<?=$value[0]?>/<?=$value[1]?>.jpeg" />
				</a>
				<figcaption>
					<music-song><?=$value[1]?></music-song>
					<music-group><?=$value[0]?></music-group>
				</figcaption>
			</figure>
		<?php endforeach;?>
	</section>
	</main>
	<footer>
	</footer>
</body>
</html>
