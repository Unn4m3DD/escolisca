#include <stdio.h>
#include <unistd.h>
unsigned long ack(unsigned long m, unsigned long n) {
  if (m == 0)
    return n + 1;
  if (n == 0)
    return ack(m - 1, 1);

  return ack(m - 1, ack(m, n - 1));
}

int main() {
  for (unsigned long i = 1; i < 6; i++) {
    for (unsigned long j = 1; j < 6; j++) {
      printf("ack(%lu,%lu) = %lu\n", i, j, ack(i, j));
      fflush(stdout);
    }
  }
  //printf("%lu", ack(1, 1));
}
