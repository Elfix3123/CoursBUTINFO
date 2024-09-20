<!DOCTYPE html>
<html lang="fr" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Mes tables de multiplication</title>
	<style>
	table, th, td {
		border: 1px solid black;
		padding: 6px;
		text-align: center;
		border-collapse: collapse;
	}
	</style>
  </head>
  <body>
    <h1>Tables de multiplication</h1>
    <p>
		<table>
			<?php
				$i = 1;
				$j;
				while ($i <= 10) {
					$j = 1;
					print("<tr>");
					while ($j <= 10) {
						if ($j == 1 || $i == 1) {
							print("<td style=\"font-weight: bold\";>");
						}
						else {
							print("<td>");
						}
						print($i * $j);
						print("</td>");
						$j++;
					}
					print("</tr>");
					$i++;
				}
			?>
		</table>
    </strong>
    </p>
  </body>
</html>
