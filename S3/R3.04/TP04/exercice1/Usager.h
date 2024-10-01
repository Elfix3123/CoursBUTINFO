#ifndef USAGER_H
#define USAGER_H

#include <string>
#include <iostream>

class Usager {
    public:
    Usager(const std::string login, const std::string groupe) : m_login(login), m_groupe(groupe) {};
    std::string const getLogin() const;
    std::string const getGroupe() const;
    
    private:
    std::string m_login;
    std::string m_groupe;
};

#endif /* USAGER_H */

