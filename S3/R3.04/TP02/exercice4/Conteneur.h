#ifndef CONTENEUR_H
#define CONTENEUR_H

#include <vector>
#include <iostream>
#include <stdexcept>

using namespace std;

template<class T>
class Conteneur {
	public:
	Conteneur();	// Constructeur par défaut
	Conteneur(const Conteneur<T> & unConteneur);	// Constructeur de copie
	Conteneur<T> & operator=(const Conteneur<T> & unConteneur);	// Opérateur d'affectation
	virtual ~Conteneur();	// Destructeur
	void ajouter(T *element);
	void afficher(istream & input, ostream & output) const;
	void afficher(ostream & output) const;

	private:
	vector<T*> m_contenu;
};

template <class T>
Conteneur<T>::Conteneur() {}

template <class T>
Conteneur<T>::Conteneur(const Conteneur<T> & unConteneur) {
	for (T *membre : this->m_contenu)
	{
		delete membre;
	}
	
	this->m_contenu.clear();

	for (T *membre : unConteneur.m_contenu)
	{
		this->m_contenu.push_back(new T(*membre));
	}
}

template<class T>
Conteneur<T> & Conteneur<T>::operator=(const Conteneur<T> & unConteneur) {
	for (T *membre : this->m_contenu)
	{
		delete membre;
	}
	
	this->m_contenu.clear();

	for (T *membre : unConteneur.m_contenu)
	{
		this->m_contenu.push_back(new T(*membre));
	}

	return *this;
}

template<class T>
Conteneur<T>::~Conteneur() {
	for (T *membre : this->m_contenu) {
		delete membre;
	}
}

template<class T>
void Conteneur<T>::ajouter(T *element) {
	this->m_contenu.push_back(new T(*element));
}

template<class T>
void Conteneur<T>::afficher(ostream & output) const{
	typename vector<T*>::const_iterator it = this->m_contenu.cbegin();
	while (it != this->m_contenu.end())
	{
		output << it - this->m_contenu.cbegin() + 1 << ". " << **it << endl;
		it++;
	}
}

template<class T>
void Conteneur<T>::afficher(istream & input, ostream & output) const{
	typename vector<T*>::const_iterator it = this->m_contenu.cbegin();
	int elt_nb;
	cin >> elt_nb;
	it += elt_nb - 1;

	output << it - this->m_contenu.cbegin() + 1 << ". " << **it << endl;
	it++;
}

#endif /* CONTENEUR_H */

