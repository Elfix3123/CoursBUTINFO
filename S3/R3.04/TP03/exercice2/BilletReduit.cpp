#include <iostream>
#include "BilletReduit.h"
using namespace std;

std::ostream &operator<<(std::ostream &sortie, const BilletReduit &billetReduit) {
    return sortie << billetReduit.getTrajet() << endl << billetReduit.getTarif() << endl << billetReduit.getPromotion() << endl << billetReduit.getPrix() << endl;
}