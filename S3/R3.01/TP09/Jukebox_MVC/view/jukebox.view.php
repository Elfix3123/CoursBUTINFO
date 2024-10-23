<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title>&#x1F399; Mon jukebox avec BD</title>
	<link rel="stylesheet" type="text/css" href="view/design/style.css">
	<title></title>
</head>
<body>
	<header>
		<h1>Ma musique dans mon Jukebox</h1>
	</header>
	<!-- Navigation -->
	<nav>
		<p>
			<a href="?ctrl=jukebox&page=1&pageSize=<?=$pagesize?>">
				<span class="arrow left"></span><span class="arrow left"></span>
			</a>
			<a href="?ctrl=jukebox&page=<?=$page-1<1 ? 1 : $page-1?>&pageSize=<?=$pagesize?>">
				<span class="arrow left"></span>
			</a>
			<?php $i = 1; while($i <= $pagenb) : ?>
			<a <?=$i == $page ? 'class="selected"' : ''?> href="?ctrl=jukebox&page=<?=$i?>&pageSize=<?=$pagesize?>"><?=$i?></a>
			<?php $i++; endwhile;?>
			<a href="?ctrl=jukebox&page=<?=$page+1>$pagenb ? $pagenb : $page+1?>&pageSize=<?=$pagesize?>">
				<span class="arrow right"></span>
			</a>
			<a href="?ctrl=jukebox&page=<?=$pagenb?>&pageSize=<?=$pagesize?>">
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
		<?php $id = $pagesize*($page-1)+1; while ($id <= $pagesize*$page && $music = Music::read($id)) :?>
		<section>
			<figure>
				<a href="?ctrl=playId&id=<?=$music->getId()?>&page=<?=$page?>&pageSize=<?=$pagesize?>">
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
