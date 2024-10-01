#include "Element.h"
#include <string>
#include <iostream>

using namespace std;

const string Element::getNom() {
	return this->m_nom;
}

void Element::setNom(const string nom) {
	this->m_nom = nom;
}

Usager const &Element::getProprietaire () {
	return *(this->r_proprietaire);
}

void Element::setProprietaire(const Usager &proprietaire) {
	this->r_proprietaire = &proprietaire;
}

void Element::afficher() {
	cout << "Nom : " << this->getNom() << endl
	<< "Propriétaire : " << this->getProprietaire().getLogin() << endl
	<< "Taille : " << this->getTaille() << endl
	<< "Date de modification : " << this->getDateModif() << endl;
}