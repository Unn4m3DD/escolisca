#include <math.h>
#include <stdio.h>
#include "./elapsed_time.h"
typedef unsigned long long ullong;
int table[50000];

ullong P_dinamic_programing(ullong n) {
  if (table[n]) return table[n];
  if (n == 0 || n == 1) return n;
  table[n] = 3 * P_dinamic_programing(n - 1) + 2 * P_dinamic_programing(n - 2);
  return table[n];
}

ullong P_recursive(ullong n) {
  if (n == 0 || n == 1) return n;
  return 3 * P_recursive(n - 1) + 2 * P_recursive(n - 2);
}

ullong P_iterative(ullong n) {
  ullong last_item1 = 0;
  ullong last_item2 = 1;
  ullong new_item;

  for (ullong i = 1; i < n; i++) {
    new_item = 3 * last_item2 + 2 * last_item1;
    last_item1 = last_item2;
    last_item2 = new_item;
  }
  return new_item;
}

ullong P_recursion_formula(ullong n) {
  return round(pow(.5 * (3 + sqrt(17)), n) - pow(.5 * (3 - sqrt(17)), n)) /
         (sqrt(17));
}
ullong P_exponential_formula(ullong n) {
  double c1 = 0.24253562503633297352;
  double c2 = 1.27019663313689157536;

  return (ullong)round(c1 * exp(c2 * n));
}

int main(void) {
  for (int i = 0; i < 20; i++) {
    elapsed_time();
    printf("%20llu",P_dinamic_programing(i));
    printf("%f , \n", elapsed_time());
    //P_recursive(i);
    //printf("%f , ", elapsed_time());
    //P_iterative(i);
    //printf("%f , ", elapsed_time());
    //P_recursion_formula(i);
    //printf("%f , ", elapsed_time());
    //P_exponential_formula(i);
    //printf("%f\n", elapsed_time());
  }
}