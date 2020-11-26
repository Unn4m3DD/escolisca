#include <stdio.h>
#include <stdlib.h>

#include "BST.h"

void heapify(long arr[], int n, int i) {
  int largest = i;
  int l = 2 * i + 1;
  int r = 2 * i + 2;

  if (l < n && arr[l] > arr[largest])
    largest = l;

  if (r < n && arr[r] > arr[largest])
    largest = r;

  if (largest != i) {
    long tmp = arr[i];
    arr[i] = arr[largest];
    arr[largest] = tmp;
    heapify(arr, n, largest);
  }
}

void buildHeap(long arr[], int n) {
  int startIdx = (n / 2) - 1;
  for (int i = startIdx; i >= 0; i--) {
    heapify(arr, n, i);
  }
}

int comparator(void* e1, void* e2) {
  return (long)e1 > (long)e2 ? 1 : (long)e1 == (long)e2 ? 0 : -1;
}

void print(void* elem) {
  printf("%ld -> ", (long)elem);
}

int main() {
  int arg = 2;
  if (arg == 1) {
    BST* bst = bst_instanteate(comparator);
    int expected_size = 0;
    for (int i = 0; i < 10; i++) {
      if (bst_add(bst, (void*)(long)(rand() % 9))) {
        expected_size++;
      }
    }
    printf("%d == %d\n", expected_size, bst_size(bst));
    bst_traverse_in_order(bst, print);
    puts("");
    bst_traverse_pre_order(bst, print);
    puts("");
    bst_traverse_post_order(bst, print);
    puts("");
    bst_traverse_breadth(bst, print);
    puts("");
    bst_destroy(&bst);
  } else {
    long arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    buildHeap(arr, 10);
    BST* bst = bst_instanteate(comparator);
    for (int i = 0; i < 10; i++) {
      printf("%ld -> ", arr[i]);
      bst_add(bst, (void*)(long)(arr[i]));
    }
    puts("");
    bst_traverse_breadth(bst, print);
    puts("");
    bst_traverse_in_order(bst, print);

    bst_destroy(&bst);
  }
  return 0;
}
