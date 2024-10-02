<?php
$password = $_POST["password"];
$file = fopen("password.txt", "w");
fwrite($file, $password);
?>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>Password updated</title>
  <link rel="stylesheet" href="style.css">
</head>

<body>
  <section>
    <h2>Password updated</h2>
    <p>You password is <?=$password?></p>
  </section>
</body>

</html>