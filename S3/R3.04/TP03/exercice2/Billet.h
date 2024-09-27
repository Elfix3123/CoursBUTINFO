#ifndef BILLET_H
#define BILLET_H

#include <iostream>
#include <iomanip>

#include "Trajet.h"
#include "Tarif.h"

class Billet {
	public:
	inline Billet(Trajet &trajet, Tarif &tarif) : m_r_trajet(trajet), m_r_tarif(tarif) {};
	inline ~Billet() {};
	inline const Trajet &getTrajet() const {return this->m_r_trajet;};
	inline const Tarif &getTarif() const {return this->m_r_tarif;};
	virtual inline const float getPrix() const {return this->getTrajet().getDistance() * this->getTarif().getPrixAuKm();};
	friend std::ostream &operator<<(std::ostream &sortie, const Billet &billet);

	private:
	Trajet const &m_r_trajet;
	Tarif const &m_r_tarif;
};
#endif