#include <cstdlib>
#include "EntierContraint.h"

using namespace std;


int main(int argc, char** argv) {
	EntierContraint *e = new EntierContraint(5, 0, 10);

	cout << "Test de getVal()" << endl
	<< "Valeur attendue : " << "5" << endl
	<< "Valeur obtenue : " << e->getVal() << endl
	<< (e->getVal() == 5 ? "Succès" : "Echec") << endl << endl;

	cout << "Test de getMin()" << endl
	<< "Valeur attendue : " << "0" << endl
	<< "Valeur obtenue : " << e->getMin() << endl
	<< (e->getMin() == 0 ? "Succès" : "Echec") << endl << endl;

	cout << "Test de getMax()" << endl
	<< "Valeur attendue : " << "10" << endl
	<< "Valeur obtenue : " << e->getMax() << endl
	<< (e->getMax() == 10 ? "Succès" : "Echec") << endl << endl;

	e->setVal(7);
	cout << "Test de setVal()" << endl
	<< "Valeur attendue : " << "7" << endl
	<< "Valeur obtenue : " << e->getVal() << endl
	<< (e->getVal() == 7 ? "Succès" : "Echec") << endl << endl;

	cout << "Test de setVal() avec une valeur hors intervalle" << endl;
	try {
		e->setVal(11);
		cout << "Echec : pas d'exception levée" << endl ;
	}
	catch (char const *erreur) {
		cout << "Succès : exception levée : " << erreur << endl ;
	}

	cout << "Test de saisir()" << endl;
	e->saisir(cin);
	
	cout << "Test de afficher()" << endl;
	e->afficher(cout);

	delete e;

	return 0;
}

