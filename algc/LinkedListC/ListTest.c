#include <malloc.h>
#include <stdio.h>

#include "LinkedList.h"

char* to_string_from_long(void* ptr) {
  long value = (long)ptr;
  int size = 0;
  int div = 1;
  while (value / div > 0) {
    size++;
    div *= 10;
  }
  if (value == 0) size++;
  char* result = (char*)malloc((size + 1) * sizeof(char));

  div = 1;
  for (int i = 0; i < size; i++) {
    result[size - 1 - i] = '0' + ((value / div) % 10);
    div *= 10;
  }
  result[size] = 0;
  return result;
}

int main() {
  LinkedList* l1 = list_instanteate();
  // LinkedList* l2 = list_instanteate();
  // LinkedList* l3 = list_instanteate();
  // LinkedList* l4 = list_instanteate();
  // LinkedList* l5 = list_instanteate();
  for (long i = 0; i < 6; i++) {
    list_add(l1, (void*)i);
  }
  list_add(l1, (void*)1000);
  printf("0 -> 1 -> 2 -> 3 -> 4 -> 5\n");
  list_print_int(l1, to_string_from_long);
  puts("\n");

  printf("6\n");
  printf("%d", list_size(l1));
  puts("\n");

  for (long i = 0; i < 2; i++) {
    list_remove_first(l1);
  }
  printf("2 -> 3 -> 4 -> 5\n");
  list_print_int(l1, to_string_from_long);
  puts("\n");

  printf("4\n");
  printf("%d", list_size(l1));
  puts("\n");

  list_insert(l1, 2, (void*)7);
  list_print_int(l1, to_string_from_long);
  puts("");

  list_add_first(l1, (void*)1);
  list_print_int(l1, to_string_from_long);
  puts("");

  LinkedList* l2 = list_clone(l1);
  list_add_first(l1, (void*)2);
  list_print_int(l1, to_string_from_long);
  puts("");
  list_print_int(l2, to_string_from_long);
  puts("");
  printf("%d\n", list_contains(l1, (void*)5));
  list_print_int(l1, to_string_from_long);
  puts("");
  printf("%ld\n", (long)list_get(l1, 6));
  printf("%d\n", list_last_index_of(l1, (void*)2));
  list_remove_first(l1);
  list_print_int(l1, to_string_from_long);

  return 0;
}
