#include <malloc.h>
#include <stdio.h>
int recursiveCall;
int T1(int n) {
  recursiveCall++;
  return n == 0 ? n : T1(n / 3) + n;
}

int T2(int n) {
  recursiveCall++;
  return (n > -1 && n < 3) ? n : T2(n / 3) + T2((n + 2) / 3) + n;
}

int T3(int n) {
  recursiveCall++;
  return (n > -1 && n < 3) ? n
                           : (n % 3 == 0 ? 2 * T3(n / 3) + n
                                         : T3(n / 3) + T3((n + 2) / 3) + n);
}

int main() {
  int (*T[3])(int) = {&T1, &T2, &T3};
  printf(
      "n,T1(n),Nº de Chamadas Recursivas,T2(n),Nº de Chamadas Recursivas,T3(n),"
      "Nº de Chamadas Recursivas\n");

  for (int i = 0; i < 200; i++) {
    printf("%d,", i);
    for (int x = 0; x < 3; x++) {
      recursiveCall = 0;
      int result = T[x](i);
      recursiveCall--;
      printf("%d,%d,", result, recursiveCall);
    }
    printf("\n");
  }
}
