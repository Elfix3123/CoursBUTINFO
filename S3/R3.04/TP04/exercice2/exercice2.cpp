#include "Parametres.h"
#include <iostream>

using namespace std;

int main() {
    Parametres p = Parametres::instanceOfParametres();
    // Afficher les paramètres initiaux
    p.afficher();
    // Instancier un thème intitulé "Urbain" et l'associer aux paramètres
    Theme *t1 = new Theme("Urbain");
    p.setTheme(*t1);
    p.afficher();
    // Instancier un joueur nommé "Yoloutre" et l'associer aux paramètres
    Joueur *j1 = new Joueur("Yoloutre");
    p.setJoueur(*j1);
    p.afficher();
    // Afficher les nouveaux paramètres
    return 0;
}

/////// TRACE ATTENDUE //////////////////////////////////
//
// Paramètres { Theme: 'Par Défaut', Joueur: 'Anonyme' }
// Paramètres { Theme: 'Urbain', Joueur: 'Yoloutre' }
//
/////////////////////////////////////////////////////////