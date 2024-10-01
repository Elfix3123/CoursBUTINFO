#ifndef FICHIER_H
#define FICHIER_H

#include <string>
#include <iostream>
#include "Element.h"

class Fichier : public Element {
	public:
	Fichier(const std::string nom, const unsigned int taille, const std::string date, const Usager &proporietaire) : Element(nom, proporietaire), m_taille(taille), m_date(date) {};
	const unsigned int getTaille() override;
	const std::string getDateModif() override;
	void setDateModif(const std::string date) override;
	void ajouter(Element *elt) override;
	~Fichier() {};

	private:
	unsigned int m_taille;
	std::string m_date;
};

#endif /* FICHIER_H */

