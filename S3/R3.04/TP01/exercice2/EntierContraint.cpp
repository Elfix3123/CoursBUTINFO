#include <iostream>
#include <string>
#include "EntierContraint.h"

using namespace std;

EntierContraint::EntierContraint(int val, int min, int max) : m_val(val), m_min(min), m_max(max){
	if (val < min || val > max)
	{
		throw "EntierContraintException : la valeur n'est pas dans l'intervalle";
	}

	return;
}

EntierContraint::EntierContraint() : m_val(VAL_DEF), m_min(MIN_DEF), m_max(MAX_DEF){return;}

EntierContraint::~EntierContraint(){return;}

int EntierContraint::getMin() const{
	return this->m_min;
}

int EntierContraint::getMax() const{
	return this->m_max;
}

int EntierContraint::getVal() const{
	return this->m_val;
}

void EntierContraint::setVal(int val){
	if (val < this->getMin() || val > this->getMax())
	{
		throw "EntierContraintException : la valeur n'est pas dans l'intervalle";
	}
	else {
		this->m_val = val;
	}

	return;
}

void EntierContraint::saisir(std::istream &entree){
	int val_temp;
	entree >> val_temp;
	this->setVal(val_temp);
}

void EntierContraint::afficher(std::ostream &sortie) const{
	sortie << this->getVal() << endl;
}