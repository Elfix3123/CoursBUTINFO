#include <cstdlib>
#include <iostream>
#include <string>
#include "Point.h"

using namespace std;

void testClassePoint(string nom, int x, int y);

int main(int argc, char** argv) {
	cout << "Test de la classe Point" << endl;
	testClassePoint("Point1", 1, 2);

	return 0;
}

void testClassePoint(string nom, int x, int y) {
	Point p(nom, x, y);

	cout << "Test de getX()" << endl
	<< "Valeur attendue : " << "0" << endl
	<< "Valeur obtenue : " << p.getX() << endl
	<< (p.getX()==x ? "Succès" : "Echec") << endl;

	cout << "Test de getY()" << endl
	<< "Valeur attendue : " << "0" << endl
	<< "Valeur obtenue : " << p.getY() << endl
	<< (p.getY()==y ? "Succès" : "Echec") << endl;

	cout << "Test de getNom()" << endl
	<< "Valeur attendue : " << "PLACEHOLDER" << endl
	<< "Valeur obtenue : " << p.getNom() << endl
	<< (p.getNom()==nom ? "Succès" : "Echec") << endl;

	p.setX(x);
	cout << "Test de setX()" << endl
	<< "Valeur attendue : " << x << endl
	<< "Valeur obtenue : " << p.getX() << endl
	<< (p.getX()==x ? "Succès" : "Echec") << endl;
	
	p.setY(y);
	cout << "Test de setY()" << endl
	<< "Valeur attendue : " << y << endl
	<< "Valeur obtenue : " << p.getY() << endl
	<< (p.getY()==y ? "Succès" : "Echec") << endl;

	p.setNom(nom);
	cout << "Test de setNom()" << endl
	<< "Valeur attendue : " << nom << endl
	<< "Valeur obtenue : " << p.getNom() << endl
	<< (p.getNom()==nom ? "Succès" : "Echec") << endl;

	cout << "Test de saisir()" << endl;
	p.saisir(cin);

	cout << "Test de afficher()" << endl;
	p.afficher(cout);
}

void testClassePointDynamique(string nom, int x, int y) {
	Point *p = new Point(nom, x, y);

	cout << "Test de getX()" << endl
	<< "Valeur attendue : " << "0" << endl
	<< "Valeur obtenue : " << p->getX() << endl
	<< (p->getX()==x ? "Succès" : "Echec") << endl;

	cout << "Test de getY()" << endl
	<< "Valeur attendue : " << "0" << endl
	<< "Valeur obtenue : " << p->getY() << endl
	<< (p->getY()==y ? "Succès" : "Echec") << endl;

	cout << "Test de getNom()" << endl
	<< "Valeur attendue : " << "PLACEHOLDER" << endl
	<< "Valeur obtenue : " << p->getNom() << endl
	<< (p->getNom()==nom ? "Succès" : "Echec") << endl;

	p->setX(x);
	cout << "Test de setX()" << endl
	<< "Valeur attendue : " << x << endl
	<< "Valeur obtenue : " << p->getX() << endl
	<< (p->getX()==x ? "Succès" : "Echec") << endl;
	
	p->setY(y);
	cout << "Test de setY()" << endl
	<< "Valeur attendue : " << y << endl
	<< "Valeur obtenue : " << p->getY() << endl
	<< (p->getY()==y ? "Succès" : "Echec") << endl;

	p->setNom(nom);
	cout << "Test de setNom()" << endl
	<< "Valeur attendue : " << nom << endl
	<< "Valeur obtenue : " << p->getNom() << endl
	<< (p->getNom()==nom ? "Succès" : "Echec") << endl;

	cout << "Test de saisir()" << endl;
	p->saisir(cin);

	cout << "Test de afficher()" << endl;
	p->afficher(cout);

	delete p;
}