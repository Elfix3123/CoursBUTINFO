#ifndef ENTIERCONTRAINT_H
#define ENTIERCONTRAINT_H

#include <iostream>
#include <limits>

class EntierContraint {
public:
    EntierContraint(int val, int min, int max);
    EntierContraint();
    ~EntierContraint();
    int getMin() const;
    int getMax() const;
    int getVal() const;
    void setVal(int val);
    void saisir(std::istream &entree);
    void afficher(std::ostream &sortie) const;
private:
    int m_val;
    int m_min;
    int m_max;
    // Constantes de Classe (static) pour définir les valeurs par défaut des attributs d'un entier contraint
    static constexpr int VAL_DEF = 0;
    static constexpr int MIN_DEF = std::numeric_limits<int>::min(); // le plus petit int possible
    static constexpr int MAX_DEF = std::numeric_limits<int>::max(); // le plus grand int possible
};

#endif /* ENTIERCONTRAINT_H */

