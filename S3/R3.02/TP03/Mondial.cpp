/**
 * \file Mondial.cpp
 * \author hb, ajouts par Felix Martins
 * 
 * \date 22-11-2018, 16:05
 * 		Ajouts le 09-12-2024
 */

#include "Mondial.h"


#include <iostream>     // pour cout
#include <iomanip>      // pour setw()
#include <sstream>
#include <iterator>		// Iterateurs pour parcours complet de vecteurs
#include <map>			// Tableaux associatifs de divisions administratives de rivières

Mondial::Mondial(const char* filename) {
	// Chargement du fichier XML en mémoire
	imageMondial.LoadFile(filename);
	// Initialisation de l'attribut racineMondial avec la racine (élément <mondial>)
	racineMondial = imageMondial.FirstChildElement();
}

void Mondial::Print() {
	imageMondial.Print();
}

/**
 * FOURNIE
 */
int Mondial::getNbAirports() const {
	// initialisation du nombre d'aéroports
	int nb = 0;
	// accéder à <airportscategory>, c'est un fils de l'élément <racineMondial>
	XMLElement* airportsCategory = racineMondial->FirstChildElement("airportscategory");
	// parcours complet des fils de <airportscategory> en les comptants
	// 1) accéder au premier fils <airport> de <airportscategory>
	XMLElement* currentAirport = airportsCategory->FirstChildElement();
	// 2) parcourir tous les <airport> qui sont des frères
	while (currentAirport != nullptr) {
		// un aéroport supplémentaire
		nb = nb + 1;
		// avancer au frère <airport> suivant de currentAirport
		currentAirport = currentAirport->NextSiblingElement();
	}
	// currentAirport n'a plus de frère {currentAirport == nullptr}, c'est le dernier
	return nb;
}

/**
 * FOURNIE
 */
void Mondial::printCountriesCode() const {
	int rank = 1; // rang du pays
	string carcodeValue; // valeur de l'attribut "car_cod" du pays courant
	// accéder à <countriescategory>, c'est un fils de l'élément <racineMondial>)
	XMLElement* countriesCategory = racineMondial->FirstChildElement("countriescategory");
	// parcours complet des fils de <countriescategory> en affichant le rang et le code
	// 1) accéder au premier fils <country> de <countriescategory>
	XMLElement* currentCountry = countriesCategory->FirstChildElement();
	// 2) parcourir tous les <country> qui sont des frères
	while (currentCountry != nullptr) {
		// traiter le pays courant
		//      1) récupérer la valeur de l'attribut "car_code"
		carcodeValue = currentCountry->Attribute("car_code");
		//      2) faire l'affichage
		cout << setw(5) << rank << " : " << carcodeValue << endl;
		// avancer au frère <country> suivant de currentCountry
		currentCountry = currentCountry->NextSiblingElement();
		// mettre à jour le rang
		rank = rank + 1;
	}
	// currentCountry n'a pas de frère {currentCountry == nullptr}, c'est fini
}


/**
 * Renvoie le nombre de deserts de l'instance courante de Mondial sans utiliser gerNbElemCat()
 *
 * @return le nombre de deserts
 */
int Mondial::getNbDeserts() const {
	// initialisation du nombre de deserts
	int nb = 0;
	// accéder à <desertscategory>, c'est un fils de l'élément <racineMondial>
	XMLElement* desertscategory = racineMondial->FirstChildElement("desertscategory");
	// parcours complet des fils de <desertscategory> en les comptants
	// 1) accéder au premier fils <desert> de <desertscategory>
	XMLElement* currentDesert = desertscategory->FirstChildElement();
	// 2) parcourir tous les <desert> qui sont des frères
	while (currentDesert != nullptr) {
		// un aéroport supplémentaire
		nb = nb + 1;
		// avancer au frère <desert> suivant de currentDesert
		currentDesert = currentDesert->NextSiblingElement();
	}
	// currentDesert n'a plus de frère {currentDesert == nullptr}, c'est le dernier
	return nb;
}

/**
 * Renvoie le nombre d'éléments de la catégorie de nom categoryName de l'instance courante de Mondial
 * 
 * @param categoryName le nom de la catégorie
 * @return le nombre d'éléments
 */
int Mondial::getNbElemCat(const string categoryName) {
	// initialisation du nombre d'éléments
	int nb = 0;
	// accéder à la catégorie (en décodant le nom), c'est un fils de l'élément <racineMondial>
	// utilisation de c_str pour la compatibilité avec FirstChildElement(const char*)
	XMLElement* category = racineMondial->FirstChildElement(this->decod_category[categoryName].c_str());
	// parcours complet des fils de la catégorie en les comptants
	// 1) accéder au premier fils de la catégorie
	XMLElement* currentElement = category->FirstChildElement();
	// 2) parcourir tous les éléments qui sont des frères
	while (currentElement != nullptr) {
		// un élément supplémentaire
		nb = nb + 1;
		// avancer à l'éléments suivant de currentElement
		currentElement = currentElement->NextSiblingElement();
	}
	// currentElement n'a plus de frère {currentElement == nullptr}, c'est le dernier
	return nb;
}

/**
 * Renvoie le XMLElement du pays de code countryName de l'instance courante de Mondial
 * 
 * @param countryName le code du pays
 * @return un pointeur vers le XMLElement du pays ou nullptr si le pays n'existe pas
 */
XMLElement* Mondial::getCountryXmlelementFromNameRec(string countryName) const {
	// On passe le nom du pays au worker avec le premier adelphe pays
	return getCountryXmlelementFromNameRecWorker(racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country"), countryName);
}

/**
 * Worker récursif de getCountryXmlelementFromNameRec
 * 
 * @param currentCountryElement le pointeur vers le pays d'ou commencer la recherche
 * @param countryName le nom du pays
 * @return un pointeur vers le XMLElement du pays ou nullptr si le pays n'existe pas
 */
XMLElement* Mondial::getCountryXmlelementFromNameRecWorker(XMLElement* currentCountryElement, string countryName) const {
	// Cas de base : currentCountryElement est nullptr, on est arrivés à la fin de la recherche sans succès
	if (currentCountryElement == nullptr) {
		return nullptr;
	}
	// Sinon, on regarde si currentCountryElement est le bon pays
	else {
		// C'est le bon et on le renvoie
		if (currentCountryElement->FirstChildElement("name")->GetText() == countryName) {
			return currentCountryElement;
		}
		// C'est le mauvais et on passe au suivant
		else {
			return getCountryXmlelementFromNameRecWorker(currentCountryElement->NextSiblingElement(), countryName);
		}
	}
}

/**
 * Renvoie le code du pays de nom countryName de l'instance courante de Mondial, ou bien lance une erreur si le pays n'existe pas
 * 
 * @param countryName le nom du pays
 * @return le code du pays
 * @throw PrecondVioleeExcep si le pays n'existe pas
 */
string Mondial::getCountryCodeFromName(string countryName) const {
	XMLElement *result = getCountryXmlelementFromNameRec(countryName);
	// On lance une erreur si aucun pays n'a été trouvé, sinon on renvoie le code
	if (result == nullptr) {
		throw PrecondVioleeExcep("Le pays de code " + countryName + " n'existe pas");
	}
	else {
		return result->Attribute("car_code");
	}
}

/**
 * Renvoie le XMLElement du pays de code countryCode de l'instance courante de Mondial
 * 
 * @param countryName le nom du pays
 * @return un pointeur vers le XMLElement du pays ou nullptr si le pays n'existe pas
 */
XMLElement* Mondial::getCountryXmlelementFromNameIter(string countryName) const {
	XMLElement *currentCountry = racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country");

	// On effectue un parcours complet des adelphes du pays jusqu'à qu'ils n'y aie plus d'adelphes ou que le nom du pays soit le bon
	while (currentCountry != nullptr && currentCountry->FirstChildElement("name")->GetText() != countryName) {
		currentCountry = currentCountry->NextSiblingElement();
	}

	return currentCountry;	// On renvoie soit nullptr soit le bon pays avec la condition du if
}

/**
 * Renvoie la population du pays de nom countryName de l'instance courante de Mondial
 * 
 * @param countryName le nom du pays
 * @return la population du pays ou -1 si le pays n'existe pas
 */
int Mondial::getCountryPopulationFromName(string countryName) const {
	XMLElement *country = getCountryXmlelementFromNameRec(countryName);

	return (country == nullptr ? -1 : stoi(getCountryXmlelementFromNameRec(countryName)->LastChildElement("population")->GetText()));
}

/**
 * Renvoie le XMLElement du pays de code countryCode de l'instance courante de Mondial, ou nullptr si le pays n'existe pas
 * 	
 * @param countryCode le code du pays
 * @return un pointeur vers le XMLElement du pays ou nullptr si le pays n'existe pas
 */
XMLElement* Mondial::getCountryXmlelementFromCode(string countryCode) const {
	XMLElement *currentCountry = racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country");

	// On effectue un parcours complet des adelphes du pays jusqu'à qu'ils n'y aie plus d'adelphes ou que le code du pays soit le bon
	while (currentCountry != nullptr && currentCountry->Attribute("car_code") != countryCode) {
		currentCountry = currentCountry->NextSiblingElement();
	}

	return currentCountry;	// On renvoie soit nullptr soit le bon pays avec la condition du if
}

/**
 * Affiche les pays frontaliers du pays de nom countryName de l'instance courante de Mondial, ou bien un message d'erreur si le pays n'existe pas
 * 
 * @param countryName le nom du pays
 */
void Mondial::printCountryBorders(string countryName) const {
	XMLElement *country = getCountryXmlelementFromNameRec(countryName);
	// On verifie si le pays a ete trouve
	if (country == nullptr) {
		cout << "Le pays : " << countryName << ", n'existe pas !" << endl;
	}
	else {
		XMLElement *currentBorder = country->FirstChildElement("border");
		// On verifie si le pays a des pays frontaliers
		if (currentBorder == nullptr) {
			cout << "Le pays : " << countryName << ", n'a aucun pays frontalier !" << endl;
		}
		else {
			cout << "Le pays : " << countryName << endl;
			// On fait un parcours complet des adelphes pays frontaliers et on les affiche	
			while (currentBorder != nullptr) {
				cout << "\t- est frontalier avec : " << getCountryXmlelementFromCode(currentBorder->Attribute("country"))->FirstChildElement("name")->GetText() << ", la longueur de sa frontière avec celui-ci est : " << currentBorder->Attribute("length") << endl;
				currentBorder = currentBorder->NextSiblingElement("border");
			}
		}
	}
}

/**
 * Renvoie le XMLElement de la rivière de nom riverName de l'instance courante de Mondial, ou nullptr si la rivière n'existe pas
 * 
 * @param riverName le nom de la rivière
 * @return un pointeur vers le XMLElement de la rivière ou nullptr si la rivière n'existe pas
 */
XMLElement* Mondial::getRiverXmlelementFromNameIter(string riverName) const {
	XMLElement *currentRiver = racineMondial->FirstChildElement("riverscategory")->FirstChildElement("river");

	// On effectue un parcours complet des adelphes de la fleuve jusqu'à qu'ils n'y aie plus d'adelphes ou que le nom de la fleuve soit le bon
	while (currentRiver != nullptr && currentRiver->FirstChildElement("name")->GetText() != riverName) {
		currentRiver = currentRiver->NextSiblingElement();
	}

	return currentRiver;	// On renvoie soit nullptr soit la bonne fleuve avec la condition du if
}

/**
 * Affiche les pays traversés par la rivière de nom riverName de l'instance courante de Mondial, ou un message d'erreur si la rivière n'existe pas
 * 
 * @param riverName le nom de la rivière
 */
void Mondial::printAllCountriesCrossedByRiver(string riverName) const {
	XMLElement *river = getRiverXmlelementFromNameIter(riverName);

	if (river == nullptr)
		cout << "Le fleuve : " << riverName << ", n'existe pas :" << endl;
	else {
		string countries = string(river->Attribute("country")) + " ";
		vector<string> splittedCountries = split(countries, ' ');

		cout << "Le fleuve : " << riverName << endl <<
		"\ttraverse les pays suivants : ";

		// On utilise un parcours complet pour parcourir la liste des codes des pays
		for (string country : splittedCountries) {
			cout << getCountryXmlelementFromCode(country)->FirstChildElement("name")->GetText() << ", ";
		}

		cout << "il a la longueur suivante : " << river->FirstChildElement("length")->GetText() << endl;
	}
}

/**
 * Affiche les pays avec des divisions administratives traversées par la rivière de nom riverName de l'instance courante de Mondial, ou un message d'erreur si la rivière n'existe pas
 * 
 * @param riverName le nom de la rivière
 */
void Mondial::printCountriesWithProvincesCrossedByRiver(string riverName) const {
	XMLElement *river = getRiverXmlelementFromNameIter(riverName);

	if (river == nullptr)
		cout << "Le fleuve : " << riverName << ", n'existe pas !" << endl;
	
	else {
		XMLElement *currentCountry = river->FirstChildElement("located");

		cout << "Le fleuve : " << riverName << endl <<
		"\ttraverse les pays suivants : ";

		// On fait un parcours complet des adelphes de currentCountry le premier pays dont une province est traversée par riverName
		while (currentCountry != nullptr) {
			cout << getCountryXmlelementFromCode(currentCountry->Attribute("country"))->FirstChildElement("name")->GetText() << ", ";
			currentCountry = currentCountry->NextSiblingElement("located");
		}

		cout << "il a la longueur suivante : " << river->FirstChildElement("length")->GetText() << endl;
	}
}

/**
 * Affiche les pays et les divisions administratives traversées par la rivière de nom riverName de l'instance courante de Mondial, ou un message d'erreur si la rivière n'existe pas
 * 
 * @param riverName le nom de la rivière
 */
void Mondial::printCountriesAndProvincesCrossedByRiver(string riverName) const {
	XMLElement *river = getRiverXmlelementFromNameIter(riverName);

	cout << "Le fleuve " << riverName << " de longueur " << river->FirstChildElement("length")->GetText() << " traverse les pays suivants : " << endl;

	if (river == nullptr)
		cout << "La rivière " << riverName << " n'existe pas" << endl;
	else {
		// On commence par récuperer les divisions administratives traversées, qu'on enregistre dans un tableau associatif avec comme clef le code du pays
		map<string, vector<string>> divisions = {};
		string currentProvinces = "";
		XMLElement *currentCountry = river->FirstChildElement("located");
		
		while (currentCountry != nullptr) {
			currentProvinces = currentCountry->Attribute("province");
			divisions[currentCountry->Attribute("country")] = split(currentProvinces, ' ');
			currentCountry = currentCountry->NextSiblingElement("located");
		}

		// On parcours ensuite les pays traversés dans l'ordre
		string countries = string(river->Attribute("country"));
		vector<string> countriesV = split(countries, ' ');

		// On utilise un parcours complet pour parcourir la liste des codes des pays
		for (string country : countriesV) {
			map<string, vector<string>>::iterator divisionsIt = divisions.find(country);
			// On verifie si le fleuve traverse des divisions administratives, càd si le code du pays est dans le tableau associatif divisions
			if (divisionsIt == divisions.end()) {
				cout << "\t- " << getCountryXmlelementFromCode(country)->FirstChildElement("name")->GetText() << endl;
			}
			else {
				cout << "\t- " << getCountryXmlelementFromCode(country)->FirstChildElement("name")->GetText() << ", où il traverse les divisions administratives suivantes : " << endl;

				for (string division : divisions[country]) {
					cout << "\t\t* " << getProvinceXmlelementFromCodesIter(country, division)->FirstChildElement("name")->GetText() << endl;
				}
				
			}
		}
	}
}

/**
 * Affiche les informations sur la ville de nom cityName de l'instance courante de Mondial, ou un message d'erreur si la ville n'existe pas
 * 
 * @param cityName le nom de la ville
 */
void Mondial::printCityInformation(string cityName) const {
	// Sachant que les villes sont des enfants de pays non-ordonnés ou de provinces non-ordonnées, qui sont elles-memes des enfants de pays non-ordonnées, on fait une recherche exhaustive des enfants villes des enfants provinces des pays et des enfants villes des pays
	XMLElement *currentCountry = racineMondial->FirstChildElement("countriescategory")->FirstChildElement("country");
	XMLElement *currentProvince = currentCountry->FirstChildElement("province");
	XMLElement *currentCity = (currentProvince == nullptr ? currentCountry->FirstChildElement("city") : currentProvince->FirstChildElement("city"));

	// Pour chaque pays, tant que la ville n'est pas trouvée
	while ((currentCity == nullptr || currentCity->FirstChildElement("name")->GetText() != cityName) && currentCountry != nullptr) {
		currentProvince = currentCountry->FirstChildElement("province");

		if (currentProvince == nullptr) {
			// Premier cas : on recherche la ville dans les enfants de currentCountry	
			currentCity = currentCountry->FirstChildElement("city");

			// Tant que la ville n'est pas trouvée	
			while (currentCity != nullptr && currentCity->FirstChildElement("name")->GetText() != cityName) {
				currentCity = currentCity->NextSiblingElement("city");
			}
		}
		else {
			// Second cas : on recherche la ville dans les enfants provinces de currentCountry

			// Pour chaque province de currentCountry, tant que la ville n'est pas trouvée
			while ((currentCity == nullptr || currentCity->FirstChildElement("name")->GetText() != cityName) && currentProvince != nullptr) {
				currentCity = currentProvince->FirstChildElement("city");

				// Tant que la ville n'est pas trouvée
				while (currentCity != nullptr && currentCity->FirstChildElement("name")->GetText() != cityName) {
					currentCity = currentCity->NextSiblingElement("city");
				}

				currentProvince = currentProvince->NextSiblingElement("province");
			}
		}
		
		currentCountry = currentCountry->NextSiblingElement("country");
	}

	// Grace aux conditions des while, on a ici soit la bonne ville soit un nullptr dans currentCity
	if (currentCity == nullptr)
		cout << "La ville " << cityName << ", n'existe pas" << endl;
	else {
		// On récupere le bon pays et eventuellement la bonne province (c'est à dire l'avant derniere traitée)
		currentCountry = currentCountry->PreviousSiblingElement("country");
		if (currentProvince != nullptr)
			currentProvince = currentProvince->PreviousSiblingElement("province");
		cout << "La ville " << cityName << endl <<
		"\t- Se trouve dans le pays : " << currentCountry->FirstChildElement("name")->GetText() << endl <<
		(currentProvince != nullptr ? "\t- Dans la division administrative : " + string(currentProvince->FirstChildElement("name")->GetText()) + "\n" : "") <<
		"\t- Sa latitude est : " << currentCity->FirstChildElement("latitude")->GetText() << endl <<
		"\t- Sa longitude est : " << currentCity->FirstChildElement("longitude")->GetText() << endl <<
		"\t- Son altitude est : " << currentCity->FirstChildElement("elevation")->GetText() << endl <<
		"\t- Sa population est : " << currentCity->LastChildElement("population")->GetText() << endl;
	}
	
}

/**
 * Affiche les informations de l'ile de nom islandName de l'instance courante de Mondial
 * 
 * @param islandName le nom de l'ile
 */
void Mondial::printIslandsInformations(string islandName) const {
	XMLElement *currentIsland = racineMondial->FirstChildElement("islandscategory")->FirstChildElement("island");

	// On effectue un parcours complet des adelphes du pays jusqu'à qu'ils n'y aie plus d'adelphes ou que le nom du pays soit le bon
	while (currentIsland != nullptr && currentIsland->FirstChildElement("name")->GetText() != islandName) {
		currentIsland = currentIsland->NextSiblingElement();
	}

	// On a a ce point soit nullptr soit la bonne ile avec la condition du if
	if (currentIsland == nullptr) {
		cout << "L'île " << islandName << ", n'existe pas !" << endl;
	}
	else {
		cout << "L'île " << islandName << endl;
		// Cas ou l'ile est dans la mer
		string seas = currentIsland->Attribute("sea");	// On stocke dans une variable pour pouvoir passer par reference à split
		if (seas != "") {
			vector<string> splittedSeas = split(seas, ' ');
			// Cas ou l'ile est dans une seule mer
			if (splittedSeas.size() == 1) {
				cout << "\t- Est dans la mer : " << getSeaXMLElementFromCode(splittedSeas[0])->FirstChildElement("name")->GetText() << endl;
			}
			// Cas ou l'ile est dans plusieurs mers
			else {
				cout << "\t- Est dans les mers : ";
				for (string sea : splittedSeas) {
					cout << getSeaXMLElementFromCode(sea)->FirstChildElement("name")->GetText() << ", ";
				}
				cout << endl;
			}
		}
		// Cas ou l'ile est dans un lac
		else if (currentIsland->Attribute("lake") != "") {
			cout << "\t- Est dans le lac : " << getLakeXMLElementFromCode(currentIsland->Attribute("lake"))->FirstChildElement("name")->GetText() << endl;
		}
		// Cas ou l'ile est dans un fleuve
		else if (currentIsland->Attribute("river") != "") {
			cout << "\t- Est dans le fleuve : " << getRiverXMLElementFromCode(currentIsland->Attribute("river"))->FirstChildElement("name")->GetText() << endl;
		}

		cout << "\t- Est dans le pays : " << getCountryXmlelementFromCode(currentIsland->Attribute("country"))->FirstChildElement("name")->GetText() << endl <<
		"\t- Sa superficie est : " << currentIsland->FirstChildElement("area")->GetText() << endl <<
		"\t- Sa latitude est : " << currentIsland->FirstChildElement("latitude")->GetText() << endl <<
		"\t- Sa longitude est : " << currentIsland->FirstChildElement("longitude")->GetText() << endl <<
		"\t- Son altitude est : " << currentIsland->FirstChildElement("elevation")->GetText() << endl;
	}
}

/**
 * Renvoie le XMLElement de la division administrative de code provinceCode du pays de code countryCode de l'instance courante de Mondial, ou bien nullptr si la province n'existe pas
 * 
 * @param countryCode le code du pays
 * @param provinceCode le code de la province
 * @return un pointeur vers le XMLElement de la province ou nullptr si la province n'existe pas
 */
XMLElement* Mondial::getProvinceXmlelementFromCodesIter(string countryCode, string provinceCode) const {
	XMLElement *country = getCountryXmlelementFromCode(countryCode);
	XMLElement *currentProvince = country->FirstChildElement("province");

	// On effectue un parcours complet des adelphes de la province jusqu'à qu'ils n'y aie plus d'adelphes ou que le code de la province soit le bon
	while (currentProvince != nullptr && currentProvince->Attribute("id") != provinceCode) {
		currentProvince = currentProvince->NextSiblingElement();
	}

	return currentProvince;	// On renvoie soit nullptr soit la bonne province avec la condition du if
}

/**
 * Renvoie le XMLElement de la mer d'id seaCode de l'instance courante de Mondial, ou bien nullptr si la mer n'existe pas
 * 
 * @param seaCode l'id de la mer
 * @return un pointeur vers le XMLElement de la mer ou nullptr si la mer n'existe pas
 */
XMLElement* Mondial::getSeaXMLElementFromCode(string seaCode) const {
	XMLElement *currentSea = racineMondial->FirstChildElement("seascategory")->FirstChildElement("sea");

	// On effectue un parcours complet des adelphes de la mer jusqu'à qu'ils n'y aie plus d'adelphes ou que l'id de la mer soit le bon
	while (currentSea != nullptr && currentSea->Attribute("id") != seaCode) {
		currentSea = currentSea->NextSiblingElement();
	}

	return currentSea;	// On renvoie soit nullptr soit la bonne mer avec la condition du if
}

/**
 * Renvoie le XMLElement du lac d'id lakeCode de l'instance courante de Mondial, ou bien nullptr si le lac n'existe pas
 * 
 * @param lakeCode l'id du lac
 * @return un pointeur vers le XMLElement du lac ou nullptr si le lac n'existe pas
 */
XMLElement* Mondial::getLakeXMLElementFromCode(string lakeCode) const {
	XMLElement *currentLake = racineMondial->FirstChildElement("lakescategory")->FirstChildElement("lake");

	// On effectue un parcours complet des adelphes du lac jusqu'à qu'ils n'y aie plus d'adelphes ou que l'id du lac soit le bon
	while (currentLake != nullptr && currentLake->Attribute("id") != lakeCode) {
		currentLake = currentLake->NextSiblingElement();
	}

	return currentLake;		// On renvoie soit nullptr soit le bon lac avec la condition du if
}

/**
 * Renvoie le XMLElement de la riviere d'id riverCode de l'instance courante de Mondial, ou bien nullptr si la riviere n'existe pas
 * 
 * @param riverCode l'id de la riviere
 * @return un pointeur vers le XMLElement de la riviere ou nullptr si la riviere n'existe pas
 */
XMLElement* Mondial::getRiverXMLElementFromCode(string riverCode) const {
	XMLElement *currentRiver = racineMondial->FirstChildElement("riverscategory")->FirstChildElement("river");

	// On effectue un parcours complet des adelphes de la riviere jusqu'à qu'ils n'y aie plus d'adelphes ou que l'id de la riviere soit le bon
	while (currentRiver != nullptr && currentRiver->Attribute("id") != riverCode) {
		currentRiver = currentRiver->NextSiblingElement();
	}

	return currentRiver;	// On renvoie soit nullptr soit la bonne riviere avec la condition du if
}

/**
 * Méthodes de service fournies
 */

template<typename Out>
void Mondial::split(string& s, char delim, Out result) const {
	stringstream ss(s);
	string item;
	while (getline(ss, item, delim)) {
		*(result++) = item;
	}
}

/**
 * Méthode à utiliser pour découper les mots d'une chaîne dans un vecteur
 * Utile pour la gestion des attributs à valeurs multiples
 * @param s chaîne à découper
 * @param delim délimiteur des mots de la chaîne à découper
 * @return vecteur contenant les mots de la chaîne découpée
 */
vector<std::string> Mondial::split(string& s, char delim) const {
	vector<std::string> elems;
	split(s, delim, back_inserter(elems));
	return elems;
}

Mondial::~Mondial() {
}