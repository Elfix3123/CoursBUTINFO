#ifndef BILLETREDUIT_H
#define BILLETREDUIT_H

#include "Billet.h"
#include "Promotion.h"

class BilletReduit : public Billet {
	public:
	inline BilletReduit(Trajet &trajet, Tarif &tarif, Promotion &promotion) : Billet(trajet, tarif), m_r_promotion(promotion) {};
	inline ~BilletReduit(){};
	inline const Promotion getPromotion() const {return this->m_r_promotion;}
	inline const float getPrix() const override {return this->m_r_promotion.calculePrixReduit(Billet::getPrix());};
	friend std::ostream &operator<<(std::ostream &sortie, const BilletReduit &billetReduit);

	private:
	Promotion const &m_r_promotion;
};
#endif