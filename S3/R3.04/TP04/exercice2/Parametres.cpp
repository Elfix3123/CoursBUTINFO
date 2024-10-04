#include "Parametres.h"
#include <iostream>
using namespace std;

Parametres *Parametres::m_instance = nullptr;

Parametres::Parametres(const string &intituleTheme) {
	this->m_instance = this;
	this->m_theme = new Theme(intituleTheme);
	this->m_joueur = new Joueur("Anonyme");
}

Parametres &Parametres::instanceOfParametres(const string &intituleTheme) {
	if (Parametres::m_instance == nullptr){
		Parametres::m_instance = new Parametres(intituleTheme);
	}
	
	return *Parametres::m_instance;
}

Theme &Parametres::getTheme() const {
	return *this->m_theme;
}

void Parametres::setTheme(Theme &theme) {
	this->m_theme = &theme;
}

Joueur &Parametres::getJoueur() const {
	return *this->m_joueur;
}

void Parametres::setJoueur(Joueur &joueur) {
	this->m_joueur = &joueur;
}

void Parametres::afficher() const {
	cout << "Paramètres { Theme: '" << this->getTheme().getIntitule()
	<< "', Joueur: '" << this->getJoueur().getPseudo() << "' }" << endl;
}