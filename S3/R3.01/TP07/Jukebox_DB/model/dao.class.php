<?php

// Le Data Access Objet pour encapsuler l'accès à la BD
class DAO
{
  // L'objet Base de Données
  private $db;

  // Constructeur chargé d'ouvrir la BD
  function __construct()
  {
    $database = 'pgsql:host=localhost;port=5432;dbname=phppdo;user=phppdo;password=phppdo';
    try {
      $this->db = new PDO($database);
      if (!$this->db) {
        die("Database error");
      }
    } catch (PDOException $e) {
      die("PDO Error :" . $e->getMessage() . " $database\n");
    }
  }

  // Méthode qui encapsule la préparation de la requête
  public function prepare(string $query) : PDOStatement
  {
    try {
      $request = $this->db->prepare($query);
      if ($request == FALSE) {
        die('PDO query Error on "' . $query . '"');
      }
    } catch (PDOException $e) {
      die('PDO query Error on "' . $query . '" ' . $e->getMessage());
    }
    return $request;
  }

  public function execute(string $query) : array
  {
    $statement = $this->prepare($query);
    $statement->execute();
    return $statement->fetchall();
  }
}