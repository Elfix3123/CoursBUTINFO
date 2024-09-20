<!DOCTYPE html>
<html lang="fr" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Mes tables de multiplication</title>
  </head>
  <body>
    <h1>Calcul</h1>
    <p>
		<table>
			<?php
				if (!(isset($_GET['a']) && isset($_GET['b']) && isset($_GET['op']))) { 
					print("Il manque des paramètres");
				}
				else {
					$a = $_GET['a'] ?? 0;
					$b = $_GET['b'] ?? 0;
					$op = $_GET['op'] ?? 0;
					print($op);

					switch ($op) {
						case "+":
							print("$a + $b = " . ($a + $b));
							break;
						
						case '-':
							print("$a - $b = " . ($a - $b));
							break;
						
						case '*':
							print("$a * $b = " . ($a * $b));
							break;
						
						case '/':
							print("$a / $b = " . ($a / $b));
							break;

						default:
							print("Opérateur inconnu");
							break;
					}
				}
			?>
		</table>
    </strong>
    </p>
  </body>
</html>
