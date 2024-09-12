// Les 2 directives ci-cessous permettent d'éviter les problèmes d'inclusions multiples d'une même classe
#ifndef POINT_H
#define POINT_H

// On inclut les librairies utilisées dans le fichier
#include <iostream>
#include <string>
// Attention : pas de clause "using namespace" dans un fichier ".h" !

class Point {
    public:
    Point();
    Point(std::string nom, int x, int y);
    ~Point();
    std::string getNom() const;
    void setNom(std::string nom);
    int getX() const;
    void setX(int x);
    int getY() const;
    void setY(int y);
    void saisir(std::istream & entree);
    void afficher(std::ostream & sortie) const;

    private:
    std::string m_nom;
    int m_x, m_y;
    static const std::string NOM_DEF;
    static constexpr int X_DEF = 0;
    static constexpr int Y_DEF = 0;
};

#endif /* POINT_H */

