//
// Created by sofas on 18/02/2020.
//

// checkar se consigo quebrar matemática
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
clock_t first;
int results[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

void tic() { first = clock(); }

void tac() { printf("%d tics\n", clock() - first); }
int division_count, prod_count, sum_count, rem_count;

// int mult=0;

int fact(int cent, int dez, int uni);

int factorial(int cent);

int factorian(int i);

int main(void) {
  tic();
  int number = 1000000;
  // number= INT_MAX;
  for (int i = 1; i <= number; ++i) {
    int fact = factorian(i);
    if (fact == i) {
      printf("%d é fatorião \n", i);
    }
  }
  tac();
  // printf("Number of multiplications: %d\n", mult);
}

int factorian(int i) {
  int sum = 0;
  while (i > 0) {
    sum += results[i % 10];  // factorial(i%10);  //algarismo menos
                             // significativo
    i = i / 10;              // joga o algarismo menos significativo fora
  }
  return sum;
}

int factorial(int cent) { /*
  * método velho que não tem em conta que recebemos sempre um numero entre 0 e 9
     int res = 1;
     for (int i = 2; i <= cent; ++i) {
         res*=i;
         mult+=1;
     }
     return res;*/
  int results[10] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
  return results[cent];
}
