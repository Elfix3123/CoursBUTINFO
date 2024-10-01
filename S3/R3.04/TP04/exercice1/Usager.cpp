#include "Usager.h"
#include <string>
#include <iostream>

using namespace std;

string const Usager::getGroupe() const {
	return this->m_groupe;
}

string const Usager::getLogin() const {
	return this->m_login;
}