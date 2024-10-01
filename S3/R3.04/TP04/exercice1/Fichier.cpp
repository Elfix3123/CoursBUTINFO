#include "Fichier.h"
#include <string>
#include <iostream>

using namespace std;

const unsigned int Fichier::getTaille() {
	return this->m_taille;
}

const string Fichier::getDateModif() {
	return this->m_date;
}

void Fichier::setDateModif(const string date) {
	this->m_date = date;
}

void Fichier::ajouter(Element *elt) {
	throw "Impossible d'ajouter un élément dans un fichier";
}