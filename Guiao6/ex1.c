#include <malloc.h>
#include <stdio.h>
#define SIZE 16
int mult_count_rec = 0;
int mult_count_din = 0;
int mot(int n) {
  if (n < 2) return 1;
  int res = mot(n - 1);
  for (int k = 0; k < n - 1; k++) {
    mult_count_rec++;
    res += mot(k) * mot(n - 2 - k);
  }
  return res;
}

int mot_dinamic(int n) {
  int table[n + 1];
  for (int i = 0; i <= n; i++) {
    if (i < 2) {
      table[i] = 1;
      continue;
    }
    int res = table[i - 1];
    for (int k = 0; k < i - 1; k++) {
      mult_count_din++;
      res += table[k] * table[i - 2 - k];
    }
    table[i] = res;
  }
  return table[n];
}

int main() {
  int res;
  printf("index, value, rec, din\n");
  for (int i = 0; i < SIZE; i++) {
    mult_count_rec = 0;
    mult_count_din = 0;
    mot(i);
    res = mot_dinamic(i);
    printf("%d,%d,%d,%d\n", i, res, mult_count_rec, mult_count_din);
  }
}