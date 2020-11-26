#include <malloc.h>
#include <stdio.h>

int f1_count = 0, f2_count = 0, f3_count = 0, f4_count = 0;

unsigned int f1(unsigned int n) {
  unsigned int i, j, r = 0;
  for (i = 1; i <= n; i++)
    for (j = 1; j <= n; j++) {
      r += 1;
      f1_count++;
    }
  return r;
}
unsigned int f2(unsigned int n) {
  unsigned int i, j, r = 0;
  for (i = 1; i <= n; i++)
    for (j = 1; j <= i; j++) {
      r += 1;
      f2_count++;
    }
  return r;
}

unsigned int f3(unsigned int n) {
  unsigned int i, j, r = 0;
  for (i = 1; i <= n; i++)
    for (j = i; j <= n; j++) {
      r += j;
      f3_count++;
    }
  return r;
}

unsigned int f4(unsigned int n) {
  unsigned int i, j, r = 0;
  for (i = 1; i <= n; i++)
    for (j = i; j >= 1; j /= 10) {
      r += i;
      f4_count++;
    }
  return r;
}

int main() {
  printf("%3s;%6s;%13s;%6s;%13s;%6s;%13s;%6s;%13s\n", "n", "f1 (n)",
         "Iterações", "f2 (n)", "Iterações", "f3 (n)", "Iterações", "f4 (n)",
         "Iterações");
  for (int i = 1; i < 41; i++) {
    f1_count = 0;
    f2_count = 0;
    f3_count = 0;
    f4_count = 0;
    int r1 = f1(i);
    int r2 = f2(i);
    int r3 = f3(i);
    int r4 = f4(i);
    printf("%3d;%6d;%11d;%6d;%11d;%6d;%11d;%6d;%11d\n", i, r1, f1_count, r2,
           f2_count, r3, f3_count, r4, f4_count);
  }
}