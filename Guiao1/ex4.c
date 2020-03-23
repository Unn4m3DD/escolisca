#include <malloc.h>
#include <stdio.h>
#include <time.h>
clock_t first;
void tic() { first = clock(); }

void tac() { printf("%d tics\n", clock() - first); }
int division_count, prod_count, sum_count, rem_count;

int fact_table[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

int* array_from_int(int number) {
  int* result = (int*)malloc(sizeof(int) * 7);
  for (int i = 6; i >= 0; i--) {
    result[i] = (number % 10);
    //rem_count++;
    number = number / 10;
    //division_count++;
  }
  return result;
}
long simple_factorial(int n) {
  if (fact_table[n] == -1)
    fact_table[n] = n == 0 ? 1 : n * simple_factorial(n - 1);
  return fact_table[n];
}

int alg1() {
  for (int i = 0; i < 1000000; i++) {
    int* num = array_from_int(i);
    int total = 0;
    int j = 0;
    for (; num[j] == 0; j++)
      ;
    for (; j < 7; j++) {
      total += simple_factorial(num[j]);
      sum_count++;
    }
    if (total == i) {
      printf("%d\n", total);
    }
    free(num);
  }
  return 0;
}

void increment_num(int* num) {
  for (int i = 6; i >= 0; i--) {
    num[i]++;
    //sum_count++;
    if (num[i] != 10) break;
    num[i] = 0;
  }
}

int alg2() {
  int* num = array_from_int(0);
  for (int i = 0; i < 1000000; i++) {
    int total = 0;
    int j = 0;
    for (; num[j] == 0; j++)
      ;
    for (; j < 7; j++) {
      total += simple_factorial(num[j]);
      //sum_count++;
    }
    if (total == i) {
      printf("%d\n", total);
    }
    increment_num(num);
  }
  return 0;
}

int main() {
  tic();
  alg2();
  tac();
  printf("sum : %d\n", sum_count);
  printf("prod : %d\n", prod_count);
  printf("div : %d\n", division_count);
  printf("rem : %d\n", rem_count);
}