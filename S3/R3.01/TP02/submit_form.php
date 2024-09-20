<?php
// Récupération des valeurs
$nom = $_GET['nom'] ?? "inconnu";
$age = $_GET['age'] ?? 0;
$genre = $_GET['genre'] ?? "inconnu";

// Calculs
// Année de naissance
$year = date("Y") - $age;

// Liste des signes
// En 1921 c'était l'année du Coq
$signe = array('Singe', 'Coq', 'Chien', 'Cochon', 'Rat', 'Buffle', 'Tigre', 'Lapin', 'Dragon', 'Serpent', 'Cheval', 'Chèvre');
$pos = 0;

?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">

<head>
  <meta charset="utf-8">
  <link rel="stylesheet" href="styles.css">
  <title>Signe Chinois</title>
</head>

<body>
  <header>
    <h1>Signes Astrologiques Chinois</h1>
  </header>
  <main>
    <p>
      Bonjour <?= $presentation ?> <?= $nom ?>, vous etes né en <?= $year ?>.
      Vous êtes du signe suivant :
    </p>
    <section>
    <?= '<img src="img/' . str_replace("è", "e", strtolower($signe[$year%12])) . '.png">'?>
      <p> 
        <?= $signe[$year%12] ?>
      </p>
    </section>
    
  </main>
  <footer>
    <p>&copy; 2024 Votre Site Astrologique</p>
  </footer>
</body>

</html>