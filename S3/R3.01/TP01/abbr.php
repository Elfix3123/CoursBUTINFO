<?php
	$abbreviations = array ('HTML' => '<abbr title="HyperText Markeup Language">HTML</abbr>', 
							'XML' => '<abbr title="eXtended Markeup Language">XML</abbr>',
							'PHP' => '<abbr title="Hypertext PreProcessor">PHP</abbr>',
							'CSS' => '<abbr title="Cascading Style Sheets">CSS</abbr>');
	// Produit en sortie (i.e. return) une chaîne avec balise abbr et le détail
	// de l'abréviation si elle existe sinon, retourne la valeur $abbr
	function abbr(string $abbr): string {
		global $abbreviations;
		return $abbreviations[$abbr] ?? $abbr;
	}

	// Produit en sortie (i.e. return) une chaine contenant un
	// tableau HTML de toutes les abrévations connues
	function abbrAll() : string {
		$retour = '';
		$retour .= '<table>';
		global $abbreviations;
		foreach ($abbreviations as $key => $value) {
			$retour .= "<tr><th>$key</th><td>$value</td></tr>";
		}
		$retour .= '</table>';
		return $retour;
	}
?>

<!DOCTYPE html>
<html lang="fr" dir="ltr">
	<head>
	<meta charset="utf-8">
	<title>Test abbr</title>
	</head>
	<style media="screen">
	abbr,th {
		color: blue;
	}
	</style>
	<body>

	<h1>Exemple d'utilisation des abréviations en HTML</h1>

	<p>Le langage <?= abbr('PHP') ?> produit généralement
		du <?= abbr('HTML') ?> mais peu produire aussi
		du <?= abbr('XML') ?> ou même
		du <?= abbr('CSS') ?>.
	</p>
	<p>Voici toutes les abbréviations connues : </p>
		<?= abbrAll() ?>
	</body>
</html>
