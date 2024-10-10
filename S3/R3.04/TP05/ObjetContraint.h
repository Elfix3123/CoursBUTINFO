#ifndef OBJETCONTRAINT_H
#define OBJETCONTRAINT_H
#include <exception>
#include <stdexcept>

// FOURNI

template <class T>
class ObjetContraint {
public:
    ObjetContraint(const T & val, const T & min, const T & max);
    ObjetContraint();
    inline const T & getMin() const {return m_min;}
    inline const T & getMax() const {return m_max;}
    inline const T & getVal() const {return m_val;}
    void setVal(const T & val);
    inline operator T() const { return getVal(); }
private:  
    T m_val;
    T m_min;
    T m_max;
};

template <class T>
ObjetContraint<T>::ObjetContraint(const T & val, const T & min, const T & max) 
: m_min(min), m_max(max) {
    setVal(val);
}

template <class T>
ObjetContraint<T>::ObjetContraint() : m_val(), m_min(), m_max() {}

template <class T>
void ObjetContraint<T>::setVal(const T & val) {
    if (getMax()<val || val < getMin())
        throw std::domain_error("Valeur Hors Intervalle Min..Max");
    else
        this->m_val=val;
}
#endif /* OBJETCONTRAINT_H */

