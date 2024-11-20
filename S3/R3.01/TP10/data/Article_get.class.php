<?php
// Taux atuel de la TVA mis comme une constante
const TVA = 20.0;

// Définition d'un article
class Article {
  // Identifiant unique de l'article
  private $id;
  // Description
  private $libelle;
  // Montant sans la taxe
  private $montant_HT;
  // Quantite
  private $quantite;

  // Construction d'un article
  function __construct(string $id,string $libelle,float $montant_HT) {
    $this->id = $id;
    $this->libelle = $libelle;
    $this->montant_HT = $montant_HT;
    $this->quantite = 1;
  }

  function __get(string $property) {
    if ($property === "montant_TTC") {
      return $this->montant_HT * $this->quantite * (1+TVA/100);
    } else if (isset($this->$property) && ($property != 'id')) {
      return $this->$property;
    } else {
      throw new Exception("reading property '$property' is not allowed");
    }
  }

  function __set(string $property, string $value) {
    if ($property === "quantite") {
      if ($value > 0) {
        $this->quantite = $value;
      }
      else {
        throw new Exception("setting quantity to a negative numebr ($value)");
      }
    }
    else {
      throw new Exception("reading property '$property' is not allowed");
    }
  }
}
 ?>
