<!DOCTYPE html>
<html lang="en" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>Vue principale du backoffice</title>
  <meta name="author" content="Jean-Pierre Chevallet" />
  <link rel="stylesheet" type="text/css" href="public/design/style.css">
</head>

<body>
  <header>
    <h1>Bricomachin: backoffice</h1>
  </header>
  <aside>
    <!-- Menu  -->
    <?php include(__DIR__ . '/menu.viewpart.php'); ?>
  </aside>
  <main>
    <h2>Mise à jour d'un article</h2>
    <form method="get">
      <input type="hidden" name="ctrl" value="article.update">
      <p>
        <label for="ref">Référence à modifier</label>
        <input type="number" id="ref" name="ref" value="<?= $ref ?>">
      </p>
      <h3>Nouvelles informations</h3>
      <p>
        <label for="libelle">Libéllé</label>
        <textarea id="libelle" name="libelle" rows="1" cols="30"><?= $libelle ?></textarea>
      </p>
      <p>
        <label for="prix">Prix</label>
        <input type="number" step=".01" id="prix" name="prix" value="<?= $prix ?>">
      </p>
      <button type="submit" name="update">Envoyer</button>
      <button type="submit" name="refresh">Actualiser</button>
    </form>
    <?php if (isset($error) && count($error) != 0) : ?>
      <output class="error">
        <p>La modification n'a pas été réalisée à cause des erreurs suivantes : </p>
        <ul>
          <?php foreach ($error as $ligne) : ?>
            <li>
              <?= $ligne ?>
            </li>
          <?php endforeach; ?>
        </ul>
      </output>
    <?php endif; ?>
    <?php if (isset($message) && $message != "") : ?>
      <output>
        <?= $message ?>
      </output>
    <?php endif; ?>
  </main>
</body>

</html>