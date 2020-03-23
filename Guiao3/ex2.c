#include <assert.h>
#include <stdio.h>
int comparissons = 0;
int solve(int* array, int size) {
  assert(size > 1);
  int result = -1;
  int best_counter = 0;
  for (int i = 0; i < size; i++) {
    int counter = 0;
    for (int j = i - 1; j >= 0; j--) {
      comparissons++;
      if (array[i] > array[j]) counter++;
    }
    if (counter > best_counter) {
      best_counter = counter;
      result = i;
    }
  }
  return result;
}

int main() {
  int array[] = {2, 3, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 4, 3, 3,
                 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 3, 4, 3, 3, 3, 3, 3, 3, 3,
                 3, 3, 3, 3, 2, 3, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
  for (int i = 5; i < 40; i *= 2) {
    comparissons = 0;
    solve(array, i);
    printf("size: %d, comparisons: %d\n", i, comparissons);
  }
}

// p1