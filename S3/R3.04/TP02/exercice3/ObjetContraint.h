#ifndef OBJETCONTRAINT_H
#define OBJETCONTRAINT_H
#include <stdexcept>

template <class T>
class ObjetContraint {
public:
	ObjetContraint(T & val, T & min, T & max);
	bool operator<(const ObjetContraint &obj) const;
	~ObjetContraint();
	T & getMin() const;
	T & getMax() const;
	T & getVal() const;
	void setVal(const T & val);
private:
	T m_val;
	T m_min;
	T m_max;
};

ObjetContraint<class T>::ObjetContraint(T & val, T & min, T & max) {
	this->setVal(val);
	this->m_min = min;
	this->m_max = max;
}

bool ObjetContraint<T>::operator<(const ObjetContraint &obj) const {
        return this->m_val < obj.getVal();
}

T & ObjetContraint<T>::getMin() const {
	return this->m_min;
}

T & ObjetContraint<T>::getMax() const {
	return this->m_max;
}

T & ObjetContraint<T>::getVal() const {
	return this->m_val;
}

void ObjetContraint<T>::setVal(const T & val) {
	if (val < this->m_min || val > this->m_max) {
		throw std::invalid_argument("La valeur doit être comprise entre min et max");
	}
	this->m_val = val;
}

#endif /* OBJETCONTRAINT_H */

