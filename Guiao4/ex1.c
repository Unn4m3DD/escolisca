#include <stdio.h>
int sub_count = 0;
int test_array(int* array, int size) {
  for (int i = 1; i < size; i++) {
    sub_count++;
    if (array[i] - array[i - 1] != 1) return 0;
  }
  return 1;
}

int main() {
  int arrays[10][10] = {
      {1, 3, 4, 5, 5, 6, 7, 7, 8, 9}, {1, 2, 4, 5, 5, 6, 7, 8, 8, 9},
      {1, 2, 3, 6, 8, 8, 8, 9, 9, 9}, {1, 2, 3, 4, 6, 7, 7, 8, 8, 9},
      {1, 2, 3, 4, 5, 7, 7, 8, 8, 9}, {1, 2, 3, 4, 5, 6, 8, 8, 9, 9},
      {1, 2, 3, 4, 5, 6, 7, 9, 9, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 8, 9},
      {1, 2, 3, 4, 5, 6, 7, 8, 9, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};

  for (int i = 0; i < 10; i++) {
    sub_count = 0;
    int result = test_array(arrays[i], 10);
    printf("{");
    char sep = ' ';
    for (int j = 0; j < 10; j++) {
      printf("%c %d", sep, arrays[i][j]);
      sep = ',';
    }
    printf("}, resultado: %d, Nº de operações %d\n", result, sub_count);
  }
}
