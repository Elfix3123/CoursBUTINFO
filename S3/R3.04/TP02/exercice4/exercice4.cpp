#include "Conteneur.h"
#include <iostream>
#include <string>
#include <stdexcept>
using namespace std;

int main(int argc, char** argv) {
    Conteneur<int> *c = new Conteneur<int>();
    int i = 1;
    while (i < 10)
    {
        c->ajouter(&i);
        i++;
    }
    Conteneur<int> *c2 = new Conteneur<int>(*c);
    c->ajouter(&i);
    c->afficher(cout);
    delete c;

    c2->afficher(cout);
    c2->afficher(cin, cout);
    delete c2;
    
    return 0;
}