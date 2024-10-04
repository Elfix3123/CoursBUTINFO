#include "Repertoire.h"
#include <string>
#include <iostream>

using namespace std;

const unsigned int Repertoire::getTaille() {
	unsigned int taille = 4;
	vector<Element *>::iterator it = this->m_contenu.begin();

	while (it != this->m_contenu.end()) {
		taille += (**it).getTaille();
		it++;
	}
	
	return taille;
}

const string Repertoire::getDateModif() {
	string date = "1970-01-01";
	vector<Element *>::iterator it = this->m_contenu.begin();
	while (it != this->m_contenu.end()) {
		if ((**it).getDateModif() < date)
		{
			date = (**it).getDateModif();
		}
		
		it++;
	}
	
	return date;
}

void Repertoire::setDateModif(const string date) {
	throw "Impossible de changer la date d'un répertoire";
}

void Repertoire::ajouter(Element *elt) {
	this->m_contenu.push_back(elt);
}

Repertoire::~Repertoire() {
	vector<Element *>::iterator it = this->m_contenu.begin();
	while (it != this->m_contenu.end()) {
		delete (*it);
		it++;
	}
}