<?php
  // Lieux ou se trouve le TP
  $location = "IUT2 de Grenoble";
  // Numéro du jour, la fonction intval convertit la chaine en entier
  $day = intval(date("d"));
  // Reste de la date
  $date = date("d/m/Y");
?>
<!DOCTYPE html>
<html lang="fr" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Ma home page</title>
  </head>
  <body>
    <h1>Ceci est ma Home page</h1>
    <p>
      Bonjour vous êtes à l'<?= $location ?>.
      Nous sommes le <?= $date?>, et nous sommes le <?= $day ?> du mois. <strong>
      <?php if ($day % 2 == 0) { ?>
        pair
      <?php } else { ?>
        impair
      <?php } ?>
    </strong>
    </p>
  </body>
</html>
