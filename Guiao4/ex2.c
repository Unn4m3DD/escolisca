#include <stdio.h>
#include <stdlib.h>

int comps = 0, copies = 0;

void print_array(int* array, int size) {
  printf("{");
  printf("%d", array[0]);
  for (int j = 1; j < size; j++) {
    printf("%c %d", ',', array[j]);
  }
  printf("}\n");
}

void swap(int* a, int* b) {
  copies++;
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

void remove_duplicates(int* array, int* size) {
  for (int i = 0; i < *size; i++) {
    for (int j = i + 1; j < *size; j++) {
      comps++;
      if (array[i] == array[j]) {
        for (int x = j; x < *size - 1; x++) {
          swap(&array[x], &array[x + 1]);
        }
        j--;
        (*size)--;
      }
    }
  }
}

int main() {
  int arrays[10][10] = {
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 2, 1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 2, 3}, {1, 1, 1, 1, 1, 1, 1, 2, 3, 4},
      {1, 1, 1, 1, 1, 1, 2, 3, 4, 5}, {1, 1, 1, 1, 1, 2, 3, 4, 5, 6},
      {1, 1, 1, 1, 2, 3, 4, 5, 6, 7}, {1, 1, 1, 2, 3, 4, 5, 6, 7, 8},
      {1, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
  for (int i = 0; i < 10; i++) {
    int size = 10;
    copies = 0;
    comps = 0;
    print_array(arrays[i], size);
    remove_duplicates(arrays[i], &size);
    print_array(arrays[i], size);
    printf("comparações: %d, copias: %d\n\n", comps, copies);
  }
}

/*
{  1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
{  1}
comparações: 9, copias: 36
{  1, 2, 2, 2, 3, 3, 4, 5, 8, 8}
{  1, 2, 3, 4, 5, 8}
comparações: 28, copias: 17
{  1, 1, 2, 2, 3, 3, 4, 5, 8, 8}
{  1, 2, 3, 4, 5, 8}
comparações: 27, copias: 18
{  1, 2, 3, 4, 6, 7, 7, 8, 8, 9}
{  1, 2, 3, 4, 6, 7, 8, 9}
comparações: 41, copias: 4
{  1, 2, 3, 4, 5, 7, 7, 8, 8, 9}
{  1, 2, 3, 4, 5, 7, 8, 9}
comparações: 41, copias: 4
{  1, 2, 3, 4, 5, 6, 8, 8, 9, 9}
{  1, 2, 3, 4, 5, 6, 8, 9}
comparações: 43, copias: 2
{  1, 2, 3, 4, 5, 6, 7, 9, 9, 9}
{  1, 2, 3, 4, 5, 6, 7, 9}
comparações: 44, copias: 1
{  1, 2, 3, 4, 5, 6, 7, 8, 8, 9}
{  1, 2, 3, 4, 5, 6, 7, 8, 9}
comparações: 44, copias: 1
{  1, 2, 3, 4, 5, 6, 7, 8, 9, 9}
{  1, 2, 3, 4, 5, 6, 7, 8, 9}
comparações: 45, copias: 0
{  1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
{  1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
comparações: 45, copias: 0
*/