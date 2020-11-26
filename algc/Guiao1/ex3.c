#include <malloc.h>
#include <stdio.h>

int alg1_counter = 0, alg2_counter = 0;
long** powers;

int* array_from_int(int number, int size) {
  int* result = (int*)malloc(sizeof(int) * size);
  for (int i = size - 1; i >= 0; i--) {
    result[i] = (number % 10);
    // rem_count++;
    number = number / 10;
    // division_count++;
  }
  return result;
}
long simple_pow(long number, long exp) {
  long result = 1;
  for (long i = 0; i < exp; i++) {
    result *= number;
  }
  return result;
}
void create_power_table(int size) {
  powers = (long**)malloc(sizeof(long*) * size);
  for (int i = 0; i < size; i++) {
    powers[i] = (long*)malloc(sizeof(long) * 10);
    for (int j = 0; j < 10; j++) powers[i][j] = simple_pow(j, i);
  }
}

void increment_num(int* num) {
  for (int i = 10; i >= 0; i--) {
    num[i]++;
    // sum_count++;
    if (num[i] != 10) break;
    num[i] = 0;
  }
}

void alg1() {
  int* num = array_from_int(0, 11);
  for (long j = 0; j < simple_pow(10, 11); j++) {
    long res = 0;
    int i = 0;
    for (; num[i] == 0 && i < 11; i++)
      ;
    int nDigits = 11 - i;

    for (; i < 11; i++) {
      res += powers[nDigits][num[i]];
      if (j <= 10) printf("%ld\n", res);
      if (res > j) continue;
    }
    if (res == j) {
      printf("%ld\n", res);
    }

    increment_num(num);
  }
  printf("\n\n");
}
void alg2() {
  for (int j = 100; j < 999; j++) {
    // int num[] = {j / 100, j / 10 % 10, j % 10};
    int res = 0;
    for (int i = 2; i >= 0; i--) {
      if (res > j) continue;
      // res += pow3(num[i]);
    }
    if (res == j) {
      printf("%d\n", res);
    }
  }
}

int main() {
  create_power_table(12);
  // for (int i = 0; i < 10; i++)
  //  for (int j = 0; j < 11; j++) printf("%d^%d = %ld\n", i, j, powers[j][i]);
  alg1();
  printf("Alg1: %d\n", alg1_counter);
  printf("Alg2: %d\n", alg2_counter);
}