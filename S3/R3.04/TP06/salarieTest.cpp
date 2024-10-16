#include "gtest/gtest.h"
#include <map>
#include "Salarie.h"
#include "SalarieException.h"
using namespace std;

TEST(SalarieTest, Constructeur) {
	ASSERT_THROW(Salarie("jean", "1123456789012", 5000), NomIncorrectException);
	ASSERT_THROW(Salarie("JEAN", "1123456789012", 5000), NomIncorrectException);
	ASSERT_THROW(Salarie("JeaN", "1123456789012", 5000), NomIncorrectException);
	ASSERT_THROW(Salarie("Jean-", "1123456789012", 5000), NomIncorrectException);
	ASSERT_THROW(Salarie("-Jean", "1123456789012", 5000), NomIncorrectException);
	ASSERT_THROW(Salarie("Jean-eude", "1123456789012", 5000), NomIncorrectException);
	ASSERT_NO_THROW(Salarie("Jéan", "1123456789012", 5000));
	ASSERT_NO_THROW(Salarie("Jean-Eude", "1123456789012", 5000));
	ASSERT_THROW(Salarie("Jean", "0123456789012", 5000), NumeroIncorrectException);
	ASSERT_THROW(Salarie("Jean", "3123456789012", 5000), NumeroIncorrectException);
	ASSERT_THROW(Salarie("Jean", "112345678901", 5000), NumeroIncorrectException);
	ASSERT_THROW(Salarie("Jean", "11234567890123", 5000), NumeroIncorrectException);
	ASSERT_NO_THROW(Salarie("Jean", "1123456789012", 5000));
	ASSERT_NO_THROW(Salarie("Jean", "2123456789012", 5000));
	ASSERT_THROW(Salarie("Jean", "2123456789012", Salarie::SMIC-1), SalaireIncorrectException);
	ASSERT_THROW(Salarie("Jean", "2123456789012", Salarie::SMIC*Salarie::COEFF_SMIC+1), SalaireIncorrectException);
	ASSERT_NO_THROW(Salarie("Jean", "2123456789012", Salarie::SMIC));
	ASSERT_NO_THROW(Salarie("Jean", "2123456789012", Salarie::SMIC*Salarie::COEFF_SMIC));

	Salarie *s = new Salarie("Jean", "1123456789012", 5000);
	ASSERT_NE(s, nullptr);
	delete s;
}

TEST(SalarieTest, GetNom) {
	Salarie *s = new Salarie("Jéan-Eude", "1123456789012", 5000);
	ASSERT_EQ(s->getNom(), "JÉAN-EUDE");
	delete s;
}

TEST(SalarieTest, SetNom) {
	Salarie *s = new Salarie("Jean", "1123456789012", 5000);
	ASSERT_THROW(s->setNom("jean"), NomIncorrectException);
	ASSERT_THROW(s->setNom("JEAN"), NomIncorrectException);
	ASSERT_THROW(s->setNom("JeaN"), NomIncorrectException);
	ASSERT_THROW(s->setNom("Jean-"), NomIncorrectException);
	ASSERT_THROW(s->setNom("-Jean"), NomIncorrectException);
	ASSERT_THROW(s->setNom("Jean-eude"), NomIncorrectException);
	ASSERT_NO_THROW(s->setNom("Jéan"));
	ASSERT_NO_THROW(s->setNom("Jean-Eude"));
	delete s;
}

TEST(SalarieTest, SetNumeroSS) {
	Salarie *s = new Salarie("Jean", "1123456789012", 5000);
	ASSERT_THROW(s->setNumeroSS("0123456789012"), NumeroIncorrectException);
	ASSERT_THROW(s->setNumeroSS("3123456789012"), NumeroIncorrectException);
	ASSERT_THROW(s->setNumeroSS("112345678901"), NumeroIncorrectException);
	ASSERT_THROW(s->setNumeroSS("11234567890123"), NumeroIncorrectException);
	ASSERT_NO_THROW(s->setNumeroSS("1123456789012"));
	ASSERT_NO_THROW(s->setNumeroSS("2123456789012"));
	delete s;
}

TEST(SalarieTest, setSalaireMensuel) {
	Salarie *s = new Salarie("Jean", "1123456789012", 5000);
	ASSERT_THROW(s->setSalaireMensuel(Salarie::SMIC-1), SalaireIncorrectException);
	ASSERT_THROW(s->setSalaireMensuel(Salarie::SMIC*Salarie::COEFF_SMIC+1), SalaireIncorrectException);
	ASSERT_NO_THROW(s->setSalaireMensuel(Salarie::SMIC));
	ASSERT_NO_THROW(s->setSalaireMensuel(Salarie::SMIC*Salarie::COEFF_SMIC));
	delete s;
}

TEST(SalarieTest, GetImpot) {
	Salarie *s = new Salarie("Jean", "1123456789012", 5000);
	ASSERT_EQ(s->getImpot(), 0.3);
	delete s;
}

