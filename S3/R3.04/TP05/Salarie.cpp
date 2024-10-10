#include "Salarie.h"
#include "SalarieException.h"
#include <ctype.h>
#include <map>
#include <limits>
#include <string>
#include <iostream>
#include <iomanip>
#include <regex>

using namespace std;

// Constantes de classe
const float                  Salarie::SMIC          = 1257.0f;
const float                  Salarie::COEFF_SMIC    = 500.0f;
const std::string            Salarie::NOM_DEF       = "Martin";
const std::string            Salarie::NUMERO_SS_DEF = "1234567890123";
const std::map<float, float> Salarie::TRANCHES_IMPOT {
	{  6000.0f, 0.000f},
	{ 12000.0f, 0.055f},
	{ 26600.0f, 0.140f},
	{ 71400.0f, 0.300f},
	{151200.0f, 0.410f},
	{std::numeric_limits<float>::max(), 0.50f} 
};
const std::regex			Salarie::NOM_REGEX("^[A-ZÀ-Ü][a-zà-ü]*(?:-[A-ZÀ-Ü][a-zà-ü]*)?$");
const std::regex			Salarie::NUMERO_SS_REGEX("^[12][0-9]{12}$");

Salarie::Salarie(const string &nom, const string &numeroSS, const float &salaireMensuel) {
	this->setNom(nom);
	this->setNumeroSS(numeroSS);
	this->setSalaireMensuel(salaireMensuel);
}

Salarie::Salarie() : m_nom(Salarie::NOM_DEF), m_numeroSS(Salarie::NUMERO_SS_DEF), m_salaireMensuel(ObjetContraint<float>(Salarie::SMIC, Salarie::SMIC, Salarie::SMIC*Salarie::COEFF_SMIC)) {}

Salarie::~Salarie() {}

const string &Salarie::getNom() const noexcept {
	return this->m_nom;
};

void Salarie::setNom(const string &nom) {
	if (regex_match(nom, Salarie::NOM_REGEX)) {
		this->m_nom = nom;
	}
	else {
		throw NomIncorrectException();
	}
};

const string &Salarie::getNumeroSS() const noexcept {
	return this->m_numeroSS;
};

void Salarie::setNumeroSS(const string &numeroSS) {
	if (regex_match(numeroSS, Salarie::NUMERO_SS_REGEX)){
		this->m_numeroSS = numeroSS;
	}
	else {
		throw NumeroIncorrectException();
	}
};

const float &Salarie::getSalaireMensuel() const noexcept {
	return this->m_salaireMensuel.getVal();
};

void Salarie::setSalaireMensuel(const float &salaireMensuel) {
	try {
		m_salaireMensuel = ObjetContraint<float>(salaireMensuel, SMIC, SMIC*COEFF_SMIC);
	}
	catch(const domain_error &e) {
		throw SalaireIncorrectException();
	}
};

const float &Salarie::getImpot() const {
	map<float, float>::const_iterator it = Salarie::TRANCHES_IMPOT.begin();
	while (it->first <= this->getSalaireMensuel()*12){
		it++;
	}
	return it->second;
};

void Salarie::saisir(istream &in, ostream &out) {
	string nom, numeroSS;
	float salaireMensuel;
	bool tryInvalid = true;
	
	while (tryInvalid) {
		out << "Nom : ";
		in >> nom;
		try {
			this->setNom(nom);
			tryInvalid = false;
		}
		catch(const NomIncorrectException &e) {
			out << "Nom incorrect, recommencez..." << endl;
		}
	}

	tryInvalid = true;
	while (tryInvalid) {
		out << "Numéro SS : ";
		in >> numeroSS;
		try {
			this->setNumeroSS(numeroSS);
			tryInvalid = false;
		}
		catch(const NumeroIncorrectException &e) {
			out << "Numéro SS incorrect, recommencez..." << endl;
		}
	}

	tryInvalid = true;
	while (tryInvalid) {
		out << "Salaire Mensuel : ";
		in >> salaireMensuel;
		try {
			this->setSalaireMensuel(salaireMensuel);
			tryInvalid = false;
		}
		catch(const SalaireIncorrectException &e) {
			out << "Salaire Mensuel incorrect, recommencez..." << endl;
		}
	}
};

void Salarie::afficher(ostream &out) const {
	out << "Informations Salarié(e) ------------------------------------" << endl <<
	"Nom : " << this->getNom() << endl <<
	"Numéro SS : " << this->getNumeroSS() << endl <<
	"Salaire Mensuel : " << this->getSalaireMensuel() << " €" << endl <<
	"Impôt Annuel : " << (this->getSalaireMensuel()*12*this->getImpot()) << " €" << endl;
};