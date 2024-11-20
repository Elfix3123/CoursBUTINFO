#ifndef PILECELLULES_H
#define	PILECELLULES_H

#include <cstdlib>
#include <iostream>
#include <new>   // gestion de l'exception bad_alloc

#include "Shared/PileInterface.h"
#include "Shared/Cellule.h"
#include "Shared/PrecondVioleeExcep.h"

using namespace std;

template<class TypeInfo>
class PileCellules : public PileInterface<TypeInfo> {
private:
	Cellule<TypeInfo>* ptrSommet; // pointeur sur le sommet de la pile;

	void vide();
	
public:
	PileCellules();
	PileCellules(const PileCellules<TypeInfo>& unePile);
	virtual ~PileCellules();

	bool estVide() const;

	void empile(const TypeInfo& nouvelleInfo);

	void depile();

	TypeInfo consulteSommet() const;

}; // end ListeChaineePile

/****************************************************************************/
/*      CONSTRUCTEURS                                                       */
/****************************************************************************/

template<class TypeInfo>
PileCellules<TypeInfo>::PileCellules() : ptrSommet(nullptr) {

} // end contructeur par défaut

template<class TypeInfo>
PileCellules<TypeInfo>::PileCellules(const PileCellules<TypeInfo>& unePile) {
	// la pile originale va être parcourue comme une liste !

	// Pointeur sur la première cellule de la liste
	Cellule<TypeInfo>* ptrPileOriginale = unePile.ptrSommet;

	// unePile est videRec
	if (ptrPileOriginale == nullptr) {
		ptrSommet = nullptr; // cette pile (la nouvelle) est vide
	} else {
		// Copie du sommet
		ptrSommet = new Cellule<TypeInfo>();
		ptrSommet->setInfo(ptrPileOriginale->getInfo());

		// avancer dans la pile originale (comme dans une liste)
		ptrPileOriginale = ptrPileOriginale->getSuivante();

		// pointeur supplémentaire pour parcourir la pile en cours de création (cette pile)
		Cellule<TypeInfo>* ptrPileNouvelle = ptrSommet;

		// copier les cellules qui restent

		while (ptrPileOriginale != nullptr) {
			// obtenir l'information portée par la cellule
			TypeInfo infoSuivant = ptrPileOriginale->getInfo();

			// créer une cellule à mettre dans la nouvelle pile
			Cellule<TypeInfo>* nouvelleCellule = new Cellule<TypeInfo>(infoSuivant);

			// lier la nouvelle cellule à la nouvelle pile
			ptrPileNouvelle->setSuivante(nouvelleCellule);

			// avancer sur les deux liste
			ptrPileNouvelle = ptrPileNouvelle->getSuivante();
			ptrPileOriginale = ptrPileOriginale->getSuivante();
		} // end while

		// la dernière cellule de la pile n'a pas de successeur
		ptrPileNouvelle->setSuivante(nullptr);
	} // end if

} // end contructeur par copie

/****************************************************************************/
/*      DESTRUCTEUR                                                         */

/****************************************************************************/

template<class TypeInfo>
PileCellules<TypeInfo>::~PileCellules() {
	vide();
} // end ~PileCellules


/****************************************************************************/
/*      METHODES UTILITAIRES PUBLIQUES                                      */

/****************************************************************************/

template<class TypeInfo>
bool PileCellules<TypeInfo>::estVide() const {
	return ptrSommet == nullptr;
}

template<class TypeInfo>
void PileCellules<TypeInfo>::empile(const TypeInfo& nouvelleInfo) {
	this->ptrSommet = new Cellule(nouvelleInfo, this->ptrSommet);
}

template<class TypeInfo>
void PileCellules<TypeInfo>::depile() {
	Cellule<TypeInfo> *nouvelleTete = this->ptrSommet->getSuivante();
	delete this->ptrSommet;
	this->ptrSommet = nouvelleTete;
}

template<class TypeInfo>
TypeInfo PileCellules<TypeInfo>::consulteSommet() const {
	if (!estVide()) {
		return ptrSommet->getInfo();
	} else { // si la pile est déjà videRec, lever une exception
		throw (exception());
	}
}

/****************************************************************************/
/*      METHODES UTILITAIRES PRIEES                                         */

/****************************************************************************/

template<class TypeInfo>
void PileCellules<TypeInfo>::vide() {
	while (!estVide())
		depile();
}


#endif	/* PILECELLULES_H */

