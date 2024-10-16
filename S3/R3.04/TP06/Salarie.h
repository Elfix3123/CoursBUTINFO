#ifndef SALARIE_H
#define	SALARIE_H

#include <string>
#include <iostream>
#include "SalarieException.h"
#include "ObjetContraint.h"
#include <map>
#include <regex>

class Salarie {
public:
    Salarie(const std::string &nom, const std::string &numeroSS, const float &salaireMensuel);
    Salarie();
    ~Salarie();
    const std::string &getNom() const noexcept;
    void setNom(const std::string &nom);
    const std::string &getNumeroSS() const noexcept;
    void setNumeroSS(const std::string &numeroSS);
    const float &getSalaireMensuel() const noexcept;
    void setSalaireMensuel(const float &salaireMensuel);
    const float &getImpot() const;
    void saisir(std::istream &in, std::ostream &out);
    void afficher(std::ostream &out) const;
    
    static const float					SMIC;
    static const float					COEFF_SMIC;
    static const std::string			NOM_DEF;
    static const std::string			NUMERO_SS_DEF;
    static const std::map<float,float>	TRANCHES_IMPOT;
    static const std::regex				NOM_REGEX;
    static const std::regex				NUMERO_SS_REGEX;
private:
    std::string m_nom;
    std::string m_numeroSS;
    ObjetContraint<float> m_salaireMensuel;
};

#endif	/* SALARIE_H */

