<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="view/design/style.css">
    <title></title>
  </head>
  <body>
    <header>
      <h1>Playing : Community Centre from Passenger</h1>
    </header>
    <nav>
      <a href="index.php?ctrl=jukebox&page=1&pageSize=8">
        back
      </a>
    </nav>
    <section>
      <figure>
        <img src="<?=$music->getCover()?>">
        <audio src="<?=$music->getMp3()?>" controls autoplay ></audio>
      </figure>
    </section>
    <br/>
  </body>
</html>
