<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<meta name="author" content="Jean-Pierre Chevallet" />
	<link rel="stylesheet" type="text/css" href="view/design/style.css">
	<title>Selection des categorie</title>
</head>
<body>
	<h1>Choisir une catégorie</h1>
	<form action="" method="get">
		<input hidden name="ctrl" value="choisirCategorie"></input>
		<?php foreach ($subCategories as $subCategorie): ?>
			<button name="idCategorie" value="<?=$subCategorie->getId()?>" type="submit"><?=$subCategorie->getNom()?></button>
		<?php endforeach; ?>
	</form>
</body>
</html>
