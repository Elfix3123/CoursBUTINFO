<?php

// Classe chargée de réaliser un change entre deux monnaies
Class Change {
	// Liste des taux indexés par deux IDF de taux séparé par un espace
	private array $rates = array();
	// Liste des IDF des devises
	// Est utile pour afficher les devises que l'on peut choisir
	private array $devises = array();

	// Constructeur
	function __construct(string $filename) {
		// Lecture des taux
		$this->load($filename);
	}

	// Charge la liste des Taux et des idf de devises
	private function load(string $filename) {
		$file = fopen($filename, "r");
		fgetcsv($file);	// Clear CSV header
		while ($line = fgetcsv($file)) {
			$this->rates[$line[0] . " " . $line[1]] = $line[2];
			
			if (!in_array($line[0], $this->devises)) {
				$this->devises[] = $line[0];
			}

			if (!in_array($line[1], $this->devises)) {
				$this->devises[] = $line[1];
			}
		}
	}

	// Calcul du taux entre deux IDF de devises
	function getRate(string $from,string $to) : float {
		if (array_key_exists($from . " " . $to, $this->rates)) {
			return $this->rates[$from . " " . $to];
		}
		else if (array_key_exists($to . " " . $from, $this->rates)) {
			return 1.0/$this->rates[$to . " " . $from];
		}
		else if ($to == $from) {
			return 1.0;
		}
		else {
			throw new Exception("La convertion " . $from . " " . $to . " n'existe pas");
		}
	}

	// Retourne toutes les devises disponibles dans un tableau de strings
	function getDevises() : array {
		return $this->devises;
	}

	// Calcul une conversion
	// Arrondit à 2 après la virgule
	function change(string $from, string $to, float $amount) : float {
		return $amount * $this->getRate($from, $to);
	}
}

?>
