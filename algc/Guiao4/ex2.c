#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
int comps = 0, copies = 0;

void print_array(int* array, int size) {
  printf("{");
  printf("%d", array[0]);
  for (int j = 1; j < size; j++) {
    printf("%c %d", ',', array[j]);
  }
  printf("}");
}

void swap(int* a, int* b) {
  copies++;
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

void remove_duplicates(int* array, int* size) {
  for (int i = 0; i < *size - 1; i++) {
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
  int arrays[13][10] = {
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 5, 1, 7, 0, 3, 9, 6, 8},          {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
      {1, 2, 1, 1, 1, 1, 1, 1, 1, 1},          {1, 1, 1, 1, 1, 1, 1, 1, 2, 3},
      {1, 1, 1, 1, 1, 1, 1, 2, 3, 1},          {1, 1, 1, 1, 1, 1, 2, 3, 4, 5},
      {1, 1, 1, 1, 1, 2, 3, 4, 5, 6},          {1, 1, 1, 1, 2, 3, 4, 5, 6, 7},
      {1, 1, 1, 2, 3, 4, 5, 6, 7, 8},          {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
      {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
  for (int i = 0; i < 13; i++) {
    int size = 10;
    copies = 0;
    comps = 0;
    print_array(arrays[i], size);
    remove_duplicates(arrays[i], &size);
    print_array(arrays[i], size);
    printf("comparações: %d, copias: %d\n\n", comps, copies);
  }
  for (int i = 1; i < 20; i++) {
    int size = i;
    copies = 0;
    comps = 0;
    print_array(arrays[11], size);
    printf(" -> ");
    remove_duplicates(arrays[11], &size);
    print_array(arrays[11], size);
    printf(" ");
    printf("comparações: %d, copias: %d\n", comps, copies);
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
comparações: 45, copias: 0,  */

/*
{1, 2, 2, 2, 3, 3, 4, 5, 8, 8} -> {1, 2, 3, 4, 5, 8}  comparações: 28, copias:
17 {1, 2, 2, 2, 3, 3, 3, 3, 8, 8} -> {1, 2, 3, 8},  comparações: 23, copias:
22{1, 2, 5, 4, 7, 0, 3, 9, 6, 8} -> {1, 2, 5, 4, 7, 0, 3, 9, 6, 8}, comparações:
45, copias: 0{1, 1, 1, 1, 1, 1, 1, 1, 1, 1} -> {1},  comparações: 9, copias:
36{1, 2, 1, 1, 1, 1, 1, 1, 1, 1} -> {1, 2},  comparações: 9, copias: 28{1, 1, 1,
1, 1, 1, 1, 1, 2, 3} -> {1, 2, 3},  comparações: 10, copias: 35{1, 1, 1, 1, 1,
1, 1, 2, 3, 4} -> {1, 2, 3, 4},  comparações: 12, copias: 33{1, 1, 1, 1, 1, 1,
2, 3, 4, 5} -> {1, 2, 3, 4, 5},  comparações: 15, copias: 30{1, 1, 1, 1, 1, 2,
3, 4, 5, 6} -> {1, 2, 3, 4, 5, 6},  comparações: 19, copias: 26{1, 1, 1, 1, 2,
3, 4, 5, 6, 7} -> {1, 2, 3, 4, 5, 6, 7},  comparações: 24, copias: 21{1, 1, 1,
2, 3, 4, 5, 6, 7, 8} -> {1, 2, 3, 4, 5, 6, 7, 8},  comparações: 30, copias:
15{1, 1, 2, 3, 4, 5, 6, 7, 8, 9} -> {1, 2, 3, 4, 5, 6, 7, 8, 9},  comparações:
37, copias: 8 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} -> {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
comparações: 45, copias: 0 {1}->{1},  comparações: 0, copias: 0 {1, 2}->{1, 2},
comparações: 1, copias: 0 {1, 2, 3}->{1, 2, 3},  comparações: 3, copias: 0 {1,
2, 3, 4}->{1, 2, 3, 4},  comparações: 6, copias: 0 {1, 2, 3, 4, 5}->{1, 2, 3, 4,
5},  comparações: 10, copias: 0 {1, 2, 3, 4, 5, 6}->{1, 2, 3, 4, 5, 6},
comparações: 15, copias: 0 {1, 2, 3, 4, 5, 6, 7}->{1, 2, 3, 4, 5, 6, 7},
comparações: 21, copias: 0 {1, 2, 3, 4, 5, 6, 7, 8}->{1, 2, 3, 4, 5, 6, 7, 8},
comparações: 28, copias: 0 {1, 2, 3, 4, 5, 6, 7, 8, 9}->{1, 2, 3, 4, 5, 6, 7, 8,
9},  comparações: 36, copias: 0 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}->{1, 2, 3, 4, 5,
6, 7, 8, 9, 10},  comparações: 45, copias: 0 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
11}->{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},  comparações: 55, copias: 0 {1, 2, 3,
4, 5, 6, 7, 8, 9, 10, 11, 12}->{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
comparações: 66, copias: 0 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}->{1, 2,
3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},  comparações: 78, copias: 0 {1, 2, 3, 4,
5, 6, 7, 8, 9, 10, 11, 12, 13, 14}->{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
14},  comparações: 91, copias: 0 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
15}->{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},  comparações: 105,
copias: 0 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16}->{1, 2, 3, 4,
5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},  comparações: 120, copias: 0 {1, 2,
3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}->{1, 2, 3, 4, 5, 6, 7, 8,
9, 10, 11, 12, 13, 14, 15, 16, 17},  comparações: 136, copias: 0 {1, 2, 3, 4, 5,
6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18}->{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
11, 12, 13, 14, 15, 16, 17, 18},  comparações: 153, copias: 0 {1, 2, 3, 4, 5, 6,
7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}->{1, 2, 3, 4, 5, 6, 7, 8, 9,
10, 11, 12, 13, 14, 15, 16, 17, 18, 19},  comparações: 171, copias: 0

*/