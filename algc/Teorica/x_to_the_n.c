#include <stdio.h>

int mult = 0;
int calls = 0;
double f1(double d, int p) {
  calls++;
  if (p == 0) return 1;
  mult++;
  return d * f1(d, p - 1);
}

double f2(double d, int p) {
  calls++;
  if (p == 1) return d;
  if (p == 0) return 1;
  mult++;
  return d * f2(d, p - 1);
}
double f3(double d, int p) {
  calls++;
  if (p == 1) return d;
  if (p == 0) return 1;
  mult++;
  return f2(d, p / 2) * f2(d, (p + 1) / 2);
}

int main() {
  double res;
  mult = 0;
  calls = 0;
  res = f1(11.0, 3);
  printf("%f, %d %d\n", res, mult, calls);
  mult = 0;
  calls = 0;
  res = f2(11.0, 3);
  printf("%f, %d %d\n", res, mult, calls);
  mult = 0;
  calls = 0;
  res = f3(11.0, 3);
  printf("%f, %d %d\n", res, mult, calls);
}