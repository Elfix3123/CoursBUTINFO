#include <cstdlib>
#include <iostream>
#include "EntierContraint.h"
using namespace std;

int main(int argc, char** argv) {
	EntierContraint *e = new EntierContraint(5,0,100); 
	int i; 
	i = int(*e);
	cout << i << endl;

	

	return 0;
}

