// #define -> constante littérale qui n'occupe pas de registre
#define N 1500000000
#define R 1.01
#define STEP 4

#define LOC volatile

int main(void)
{
  LOC double suite = 1.01;

  for ( LOC unsigned long i = 0; i<N; ++i)
  {
    if (i%STEP)
    	suite += R;
  }

  suite = 0; 
  return (int)suite/10;
}
