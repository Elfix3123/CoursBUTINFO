#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <limits>

using namespace std;

#include "Salarie.h"

int main(int argc, char **argv) {
	Salarie *s = new Salarie();
	s->saisir(cin, cout);
	s->afficher(cout);
	delete s;
	return 0;
}