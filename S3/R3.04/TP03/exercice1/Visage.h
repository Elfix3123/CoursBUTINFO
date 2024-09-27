#ifndef VISAGE_H
#define VISAGE_H

#include "AttributsVisage.h"
#include <vector>

class Visage {
public:
	Visage(int longueurNez, const Variete &uneVariete);
	void setMoustache(int largeur);
	void addBouton(int diametre);
	void setChapeau(const Chapeau &unChapeau);
	void addBijou(const Bijou *unBijou);
	const Visage &operator=(const Visage &unVisage);
	Visage(const Visage &unVisage);
	~Visage();

	// fonction amie : aura accès aux attributs "private"  de la classe Visage (pour éviter d'écrire les getters)
	// attention ce n'est pas une méthode !
	friend std::ostream &operator<<(std::ostream &sortie, const Visage &visage);

private:
	Nez m_nez;
	const Variete &m_variete;
	Moustache *m_pt_moustache;
	std::vector<Bouton> m_boutons;
	const Chapeau *m_pt_chapeau;
	std::vector<const Bijou *> m_bijoux;
};

#endif /* VISAGE_H */

