<?php
// Partie CONTRÔLE de cette page WEB
// Placer ici la récupération des données de la query string et le calcul
$C = $_GET['temp_in'] ?? NAN;
if (!is_numeric($C) || is_nan($C)) {
  $F = "X";
}
else {
  $F = 1.8 * $C + 32;
}
// La suite est la partie VUE
?>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Conversion Celcius/Fahrenheit</title>
    <link rel="stylesheet" href="design/style.css">
  </head>
  <body>
    <h1>Conversion de températures</h1>
    <form  action="conversion1.php" method="get">
      <input id="in" type="number" step="any" name="temp_in" value="">
      <label for="in">Celcius</label>
      égal
      <output id="out" for="in" name="temp_out"><?=$F?></output>
      <label for="out">fahrenheit</label>
      <button type="submit" name="action" value="convertir">Convertir</button>
    </form>
  </body>
</html>
