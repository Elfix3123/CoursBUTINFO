<?php
// Inclusion du modèle
require_once('model/music.class.php');
require_once('model/dao.class.php');

$page = $_GET['page'] ?? 1;
$pagesize = $_GET['pagesize'] ?? 8;

$id = 1;
$music;
?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>&#x1F399; Mon jukebox avec BD</title>
	<link rel="stylesheet" type="text/css" href="design/style.css">
	<title></title>
</head>
<body>
	<header>
		<h1>Ma musique dans mon Jukebox</h1>
	</header>
	<!-- Navigation -->
	<nav>
		<p>
			<a href="jukebox.php?page=1&pageSize=8">
				<span class="arrow left"></span><span class="arrow left"></span>
			</a>
			<a href="jukebox.php?page=1&pageSize=8">
				<span class="arrow left"></span>
			</a>
			<a class="selected" href="jukebox.php?page=1&pageSize=8">1        </a>
			<a href="jukebox.php?page=2&pageSize=8">2          </a>
			<a href="jukebox.php?page=3&pageSize=8">3          </a>
			<a href="jukebox.php?page=4&pageSize=8">4          </a>
			<a href="jukebox.php?page=5&pageSize=8">5          </a>
			<a href="jukebox.php?page=6&pageSize=8">6          </a>
			<a href="jukebox.php?page=7&pageSize=8">7          </a>
			<a href="jukebox.php?page=8&pageSize=8">8          </a>
			<a href="jukebox.php?page=9&pageSize=8">
				<span class="arrow right"></span>
			</a>
			<a href="jukebox.php?page=70&pageSize=8">
				<span class="arrow right"></span><span class="arrow right"></span>
			</a>
		</p>
		<form action="" method="get">
			<p>Musiques/page</p>
			<input type="text" value="8" maxlength="4" size="2">
		</form>
	</nav>

	<!-- Contenu principal -->
	<main>
		<?php while ($id <= $pagesize && $music = Music::read($id)) :?>
		<section>
			<figure>
				<a href="playId.php?id=<?=$music->getId()?>&page=1&pageSize=8">
					<img src="<?=$music->getCover()?>" />
				</a>
				<figcaption>
					<music-song><?=$music->getTitle()?></music-song>
					<music-group><?=$music->getAuthor()?></music-group>
					<music-category><?=$music->getCategory()?></music-category>
				</figcaption>
			</figure>
		</section>
		<?php $id++; endwhile;?>
	</main>
	<footer>
		Jukebox IUT
	</footer>
</body>
</html>
