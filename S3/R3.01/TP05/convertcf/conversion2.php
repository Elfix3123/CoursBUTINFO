<?php
// Partie CONTRÔLE de cette page WEB
// Placer ici la récupération des données de la query string et le calcul

// Récupération du sens, de l'action à réaliser et de la température en entrée

$action = $_GET["action"] ?? "convertir";
$sens = $_GET["sens"] ?? "C2F";
$temp_in = $_GET["temp_in"] ?? "";

if ($action == "inverser") {
  if ($sens == "C2F") {
    $sens = "F2C";
  }
  else {
  $sens = "C2F";
  }
}

if (!is_numeric($temp_in)) {
  $temp_out = "X";
}
else {
  $temp_out = $sens == "C2F" ? 1.8 * $temp_in + 32 : ($temp_in - 32) / 1.8;
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
  <form  action="conversion2.php" method="get">
    <button type="submit" name="action" value="inverser">Inverser</button>
    <input id="in" type="number" step="any" name="temp_in" value="<?=$action == "convertir" ? $temp_in : $temp_out?>">
    <label for="in"><?=$sens == "C2F" ? "celcius" : "fahrenheit"?></label>
    égal
    <output id="out" for="in" name="temp_out"><?=$temp_out?></output>
    <label for="out"><?=$sens == "F2C" ? "celcius" : "fahrenheit"?></label>
    <input id="sens" name="sens" type="hidden" value="<?=$sens?>" />
    <button type="submit" name="action" value="convertir">Convertir</button>
  </form>
</body>
</html>