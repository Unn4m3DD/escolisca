#include <stdio.h>
#include "LinkedList.h"

int main(){
  LinkedList* l1 = list_instanteate();
  //LinkedList* l2 = list_instanteate();
  //LinkedList* l3 = list_instanteate();
  //LinkedList* l4 = list_instanteate();
  //LinkedList* l5 = list_instanteate();
  for(long i = 0; i < 15; i++){
    list_add(l1, (void*)i);
  }
  list_print_int(l1);
  return 0;
}