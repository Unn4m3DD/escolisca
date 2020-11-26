#include <stdio.h>

int horner_count, calc_pol_count;

int horner(int* arr, int size, int x) {
  horner_count++;
  return size == 1 ? arr[0] : arr[0] + x * horner(arr + 1, size - 1, x);
}

int calc_pol(int* arr, int size, int x) {
  int res = 0;
  int current_pow = 1;
  for (int i = 0; i < size; i++) {
    calc_pol_count += 2;
    res += arr[i] * current_pow;
    current_pow *= x;
  }
  return res;
}

int main() {
  int pol[20] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
  for (int i = 1; i < 10; i++) {
    horner_count = 0;
    int res1 = horner(pol, i, 2);
    calc_pol_count = 0;
    int res2 = calc_pol(pol, i, 2);
    printf("%d,%d,%d\n", i, calc_pol_count, horner_count);
  }
}