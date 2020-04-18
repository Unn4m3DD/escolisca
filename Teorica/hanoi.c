#include <stdio.h>

int counter = 0;

void move(char src, char dest) {
  counter++;
  // printf("%c -> %c\n", src, dest);
}

void solve(char src, char dest, char tmp, int level) {
  if (level == 1) {
    move(src, dest);
    return;
  }
  solve(src, tmp, dest, level - 1);
  move(src, dest);
  solve(tmp, dest, src, level - 1);
}

int main() {
  for (int i = 1; i < 10; i++) {
    counter = 0;
    solve('a', 'c', 'b', i);
    printf("%d -> %d\n", i, counter);
  }
  
}