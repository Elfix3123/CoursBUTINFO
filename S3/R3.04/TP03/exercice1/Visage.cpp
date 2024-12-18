#include "Visage.h"
#include <iostream>
using namespace std;

// A COMPLETER : IMPLEMENTER LES METHODES DE LA CLASSE VISAGE (ET L'OPERATEUR <<)

Visage::Visage(int longueurNez, const Variete &uneVariete) : m_nez(Nez(longueurNez)), m_variete(uneVariete), m_pt_moustache(nullptr), m_pt_chapeau(nullptr) { }

Visage::Visage(const Visage &unVisage) : m_nez(Nez(unVisage.m_nez.getLongueur())), m_variete(unVisage.m_variete), m_pt_moustache(nullptr), m_pt_chapeau(nullptr) {
	if (unVisage.m_pt_moustache != nullptr) {
		this->m_pt_moustache = new Moustache(unVisage.m_pt_moustache->getLargeur());
	}
	if (unVisage.m_pt_chapeau != nullptr) {
		this->m_pt_chapeau = unVisage.m_pt_chapeau;
	}
	for (Bouton bouton : unVisage.m_boutons) {
		this->m_boutons.push_back(Bouton(bouton.getDiametre()));
	}
	for (const Bijou *bijou : unVisage.m_bijoux) {
		this->m_bijoux.push_back(bijou);
	}
}

void Visage::setMoustache(int largeur) {
	if (this->m_pt_moustache != nullptr)
	{
		delete this->m_pt_moustache;
	}
	this->m_pt_moustache = new Moustache(largeur);
}

void Visage::addBouton(int diametre) {
	this->m_boutons.push_back(Bouton(diametre));
}

void Visage::setChapeau(const Chapeau &unChapeau) {
	this->m_pt_chapeau = &unChapeau;
}

void Visage::addBijou(const Bijou *unBijou) {
	this->m_bijoux.push_back(unBijou);
}

const Visage &Visage::operator=(const Visage &unVisage) {
	this->m_nez = Nez(unVisage.m_nez.getLongueur());
	if (this->m_variete.getType() != unVisage.m_variete.getType())
	{
		throw "Changement de variété interdit";
	}
	
	if (unVisage.m_pt_moustache != nullptr) {
		this->m_pt_moustache = new Moustache(unVisage.m_pt_moustache->getLargeur());
	}
	else {
		this->m_pt_moustache = nullptr;
	}
	if (unVisage.m_pt_chapeau != nullptr) {
		this->m_pt_chapeau = unVisage.m_pt_chapeau;
	}
	else {
		this->m_pt_chapeau = nullptr;
	}
	for (Bouton bouton : unVisage.m_boutons) {
		this->m_boutons.push_back(Bouton(bouton.getDiametre()));
	}
	for (const Bijou *bijou : unVisage.m_bijoux) {
		this->m_bijoux.push_back(bijou);
	}

	return *this;
}


Visage::~Visage() {
	delete this->m_pt_moustache;
}

std::ostream &operator<<(std::ostream &sortie, const Visage &visage) {
	sortie << "Attributs du Visage :" << endl << visage.m_variete << endl << visage.m_nez << endl;
	if (visage.m_pt_moustache == nullptr) {
		sortie << "- pas de moustache" << endl;
	}
	else {
		sortie << *(visage.m_pt_moustache) << endl;
	}
	if (visage.m_pt_chapeau == nullptr) {
		sortie << "- pas de chapeau" << endl;
	}
	else {
		sortie << *(visage.m_pt_chapeau) << endl;
	}
	for (Bouton bouton : visage.m_boutons) {
		sortie << bouton << endl;
	}
	for (const Bijou *bijou : visage.m_bijoux) {
		sortie << *bijou << endl;
	}

	return sortie;
}