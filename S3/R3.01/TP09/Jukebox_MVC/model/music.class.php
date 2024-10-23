<?php
require_once(__DIR__ . "/dao.class.php");

// Description d'une musique
class Music
{
  private int $id;
  private string $author;
  private string $title;
  private string $cover;
  private string $mp3;
  private string $category;
  // Chemin URL à ajouter pour avoir l'URL du MP3 et du COVER
  private const URL = 'http://www-info.iut2.upmf-grenoble.fr/intranet/enseignements/ProgWeb/data/musiques/';

  function __construct(int $id, string $author, string $title, string $cover, string $mp3, string $category)
  {
    $this->id = $id;
    $this->author = $author;
    $this->title = $title;
    $this->cover = $cover;
    $this->mp3 = $mp3;
    $this->category = $category;
  }

  public function getId(): int
  {
    return $this->id;
  }

  public function getAuthor(): string
  {
    return $this->author;
  }

  public function getTitle(): string
  {
    return $this->title;
  }

  public function getCover(): string
  {
    return Music::URL.'/img/'.$this->cover;
  }

  public function getMp3(): string
  {
    return Music::URL.'/mp3/'.$this->mp3;
  }

  public function getCategory(): string
  {
    return $this->category;
  }

  ////////////// READ /////////////////////////////////////////////

  // Acces à une musique connaissant sa référence
  // $id : l'identifiant de la musique
  public static function read(int $id): bool|Music
  {
    // Ouverture le la BD par création d'un DAO
    $dao = new DAO();
    $request = $dao->prepare("SELECT * FROM music WHERE id = $id;");
    $request->execute();
    $result = $request->fetch();
    if (!$result) {
      return false;
    }
    else {
      return new Music($result['id'], $result['author'], $result['title'], $result['cover'], $result['mp3'],$result['category']);
    }
  }

  // Max Id
  public static function maxId() : int
  { 
    return 554;
  }
}
