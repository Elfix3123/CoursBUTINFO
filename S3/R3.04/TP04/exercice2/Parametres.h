#ifndef PARAMETRES_H
#define PARAMETRES_H
#include <string>
#include "Theme.h"
#include "Joueur.h"

class Parametres {
	public:
	static Parametres &instanceOfParametres(const std::string &intituleTheme = "Par Défaut");
	Theme &getTheme() const;
	void setTheme(Theme &theme);
	Joueur &getJoueur() const;
	void setJoueur(Joueur &joueur);
	void afficher() const;

	protected:
	Parametres(const std::string &intituleTheme = "Par Défaut");

	private:
	static Parametres *m_instance;
	Theme *m_theme;
	Joueur *m_joueur;
};

#endif /* PARAMETRES_H */
