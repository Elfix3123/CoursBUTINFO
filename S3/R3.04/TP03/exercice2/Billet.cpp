#include <iostream>
#include "Billet.h"
using namespace std;

std::ostream &operator<<(std::ostream &sortie, const Billet &billet) {
    return sortie << billet.getTrajet() << endl << billet.getTarif() << endl << billet.getPrix() << endl;
}
