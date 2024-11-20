#include <cstdlib>
#include <iostream>
#include <iomanip>
#include <vector>

using namespace std;

template<class T>
void afficheVecteur(const vector<T> v) {
	// {v.size() > 0} => {pretty print de v}
	cout << "[" << v[0];
	int i = 1;
	while (i < v.size()) {
		cout << ", " << v[i];
		i++;
	}
	cout << "]" << endl;
}

template<class T>
void minMaxIter(const vector<T> v, T &min, T &max, int &nbComp) {
	// {v.size()≥ 1} => {min = plus petite valeur de v,
	//                   max = plus grande valeur de v,
	//                   nbcomp = nombre de comparaisons impliquant au moins un élément de v}
	int i = 0;
	min = v.at(i);
	max = v.at(i);
	i++;
	while (i < v.size()) {
		nbComp++;
		if (min > v.at(i)) {
			min = v.at(i);
		}
		nbComp++;
		if (max < v.at(i)) {
			max = v.at(i);
		}
		i++;
	}
}

template<class T>
void minMaxRec(const vector<T>& v, int inf, int sup, T &min, T &max, int &nbComp) {
	// {v.size()≥ 1} => {min = plus petite valeur de v sur l'intervalle [inf..sup],
	//                   max = plus grande valeur de v sur l'intervalle [inf..sup],
	//                   nbcomp = nombre de comparaisons impliquant au moins un élément de v}
	if (inf == sup) {
		min = v.at(inf);
		max = v.at(inf);
	}
	else if (inf == sup-1) {
		nbComp++;
		if (v.at(inf) > v.at(sup)) {
			min = v.at(inf);
			max = v.at(sup);
		}
		else {
			min = v.at(sup);
			max = v.at(inf);
		}
	}
	else {
		int lmin, lmax;
		minMaxRec(v, inf, (inf+sup)/2, lmin, lmax, nbComp);
		int rmin, rmax;
		minMaxRec(v, (inf+sup)/2+1, sup, rmin, rmax, nbComp);
		
		nbComp++;
		if (lmin < rmin) {
			min = lmin;
		}
		else {
			min = rmin;
		}

		nbComp++;
		if (lmax > rmax) {
			max = lmax;
		}
		else {
			max = rmax;
		}
	}
}

void testMinMaxIter() {
	cout << "***************************" << endl;
	cout << "*        min max iter     *" << endl;
	cout << "***************************" << endl;

	int min;
	int max;
	int nbComp = 0;

	vector<int> v = {10};
	minMaxIter(v, min, max, nbComp);
	cout << "v : ";
	afficheVecteur(v);
	cout << "Taille du vecteur = " << v.size() << " -> " << " min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

	nbComp = 0;
	v = {10, 3, 6, 8, 67, 2, 9, 1};
	minMaxIter(v, min, max, nbComp);
	cout << "v : ";
	afficheVecteur(v);
	cout << "Taille du vecteur = " << v.size() << " -> " << " min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

	nbComp = 0;
	v.clear();
	srand((unsigned)time(NULL));
	for (int i =0; i < 128; i++){
		int b = rand() % 128 + 1;
		v.push_back(b);
	}
	minMaxIter(v, min, max, nbComp);
	cout << "v : ";
	afficheVecteur(v);
	cout << "Taille du vecteur = " << v.size() << " -> " << " min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;
}

void testMinMaxDR() {
	cout << "***************************" << endl;
	cout << "*         min max DR      *" << endl;
	cout << "***************************" << endl;

	int min;
	int max;
	int inf;
	int sup;
	int nbComp = 0;

	vector<int> v = {10};
	inf = 0;
	sup = v.size()-1;
	minMaxRec(v, inf, sup, min, max, nbComp);
	cout << "v : ";
	afficheVecteur(v);
	cout << "Taille du vecteur = " << v.size() <<  " -> min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

	nbComp = 0;
	v = {10, 3, 6, 8, 67, 2, 9, 1};
	inf = 0;
	sup = v.size()-1;
	minMaxRec(v, inf, sup, min, max, nbComp);
	cout << "v : ";
	afficheVecteur(v);
	cout << "Taille du vecteur = " << v.size() <<  " -> min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;

	nbComp = 0;
	v.clear();
	srand((unsigned)time(NULL));
	for (int i =0; i < 128; i++){
		int b = rand() % 128 + 1;
		v.push_back(b);
	}
	inf = 0;
	sup = v.size()-1;
	minMaxRec(v, inf, sup, min, max, nbComp);
	cout << "v : ";
	afficheVecteur(v);
	cout << "Taille du vecteur = " << v.size() << " -> min = " << min << ", max = " << max << ", nbComp = " << nbComp << endl << endl;
}

int main(int argc, char **argv) {

	testMinMaxIter();
	testMinMaxDR();

	return 0;
}
