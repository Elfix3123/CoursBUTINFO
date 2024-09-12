// Dans le fichier d'implémentation d'une classe, on doit inclure le fichier de spécification de cette classe
#include "Point.h"

// Et on inclura aussi les librairies utilisées ici
#include <iostream>
#include <string>

using namespace std;

const string Point::NOM_DEF = "PLACEHOLDER";

Point::Point() : m_nom(NOM_DEF), m_x(X_DEF), m_y(Y_DEF) {}

Point::Point(std::string nom, int x, int y) : m_nom(nom), m_x(x), m_y(y) {}

Point::~Point() {}

std::string Point::getNom() const {
	return this->m_nom;
}

void Point::setNom(std::string nom) {
	this->m_nom = nom;
}

int Point::getX() const {
	return this->m_x;
}

void Point::setX(int x) {
	this->m_x = x;
}

int Point::getY() const {
	return m_y;
}

void Point::setY(int y) {
	this->m_y = y;
}

void Point::saisir(std::istream &entree) {
	entree >> this->m_nom >> this->m_x >> this->m_y;
	
}

void Point::afficher(std::ostream &sortie) const {
	sortie << "Nom: " << this->m_nom << ", x: " << this->m_x << ", y: " << this->m_y << endl;
}