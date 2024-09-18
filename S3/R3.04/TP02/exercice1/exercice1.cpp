#include <cstdlib>
#include <iostream>
#include "EntierContraint.h"
using namespace std;

int main(int argc, char** argv) {
	EntierContraint *e = new EntierContraint(5,0,100); 
	int i; 
	i = int(*e);
	cout << i << endl;

	cin >> *e;
	cout << *e << endl;

	return 0;
}

