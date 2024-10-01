#ifndef ELEMENT_H
#define ELEMENT_H

#include <string>
#include <iostream>
#include "Usager.h"

class Element {
	public:
	Element(const std::string nom, const Usager &proprietaire) : m_nom(nom), r_proprietaire(&proprietaire) {};
	std::string const getNom();
	void setNom(const std::string nom);
	Usager const &getProprietaire();
	void setProprietaire(const Usager &proprietaire);
	virtual const unsigned int getTaille() = 0;
	virtual const std::string getDateModif() = 0;
	virtual void setDateModif(const std::string date) = 0;
	virtual void afficher();
	virtual void ajouter(Element *elt);
	virtual ~Element() {};

	private:
	std::string m_nom;
	const Usager *r_proprietaire;
};

#endif /* ELEMENT_H */

