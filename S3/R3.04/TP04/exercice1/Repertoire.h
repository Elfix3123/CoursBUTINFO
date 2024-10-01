#ifndef REPERTOIRE_H
#define REPERTOIRE_H

#include <string>
#include <vector>
#include <iostream>
#include "Element.h"

class Repertoire : public Element {
	public:
	Repertoire(const std::string nom, const Usager &proporietaire) : Element(nom, proporietaire) {};
	const unsigned int getTaille() override;
	const std::string getDateModif() override;
	void setDateModif(const std::string date) override;
	void ajouter(Element *elt) override;
	~Repertoire();

	private:
	std::vector<Element *> m_contenu;
};

#endif /* REPERTOIRE_H */

