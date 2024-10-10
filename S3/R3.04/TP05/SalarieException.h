#ifndef SALARIEEXCEPTION_H
#define SALARIEEXCEPTION_H
#include <stdexcept>


// Toutes les exceptions de la classe Salarie seront dues à des valeurs non conformes (nom, numéro SS ou salaire)
// On va donc faire dériver SalarieExcemtion de domain_error qui est l'exception prédéfinie dans <stdexcept> pour ce genre de situation

class SalarieException : public std::exception {
	public:
	SalarieException() {};
	virtual const char *what() const noexcept = 0;
};

class NomIncorrectException : public SalarieException {
	public:
	NomIncorrectException() {};
	virtual const char *what() const noexcept override {return "NomIncorrectException";};
};

class NumeroIncorrectException : public SalarieException {
	public:
	NumeroIncorrectException() {};
	virtual const char *what() const noexcept override {return "NumeroIncorrectException";};
};

class SalaireIncorrectException : public SalarieException {
	public:
	SalaireIncorrectException() {};
	virtual const char *what() const noexcept override {return "SalaireIncorrectException";};
};

#endif /* SALARIEEXCEPTION_H */

