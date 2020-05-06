// NMEC: 93357
//
// Joaquim Madeira, AlgC, April 2020
// João Manuel Rodrigues, AlgC, May 2020
//
// Adapted from Tomás Oliveira e Silva, AED, September 2015
//
// SORTED LIST implementation based on an linked list
//
#include "SortedList.h"

#include <assert.h>
#include <stdlib.h>

struct _ListNode {
  void* item;
  struct _ListNode* next;
};

struct _SortedList {
  int size;
  struct _ListNode* head;
  struct _ListNode* tail;
  struct _ListNode* current;
  int currentPos;
  compFunc compare;
};

List* ListCreate(compFunc compF) {
  List* l = (List*)malloc(sizeof(List));
  if (l == NULL) abort();
  l->size = 0;
  l->head = NULL;
  l->tail = NULL;
  l->current = NULL;
  l->currentPos = -1;
  l->compare = compF;
  ListTestInvariants(l);
  return l;
}

void ListDestroy(List** p) {
  assert(*p != NULL);
  List* l = *p;
  ListClear(l);
  free(l);
  *p = NULL;
}

void ListClear(List* l) {
  struct _ListNode* p = l->head;
  struct _ListNode* aux;

  while (p != NULL) {
    aux = p;
    p = aux->next;
    free(aux);
  }

  l->size = 0;
  l->head = NULL;
  l->tail = NULL;
  l->current = NULL;
  l->currentPos = -1;
}

int ListGetSize(const List* l) { return l->size; }

int ListIsEmpty(const List* l) { return (l->size == 0); }

int ListCurrentIsInside(const List* l) { return (l->current != NULL); }

int ListGetCurrentPos(const List* l) { return l->currentPos; }

void* ListGetCurrentItem(const List* l) {
  assert(ListCurrentIsInside(l));
  return l->current->item;
}

void ListSetCurrentItem(const List* l, void* p) {
  assert(ListCurrentIsInside(l));
  l->current->item = p;
}

void ListMove(List* l, int newPos) {
  assert(-1 <= newPos && newPos <= l->size);
  if (newPos == l->size) newPos = -1;

  if (newPos == -1) {
    l->current = NULL;
  } else if (newPos == 0) {
    l->current = l->head;
  } else if (newPos == l->size - 1) {
    l->current = l->tail;
  } else {
    // Pode ser melhorado tendo em conta o node atual
    l->current = l->head;
    for (int i = 0; i < newPos; i++) {
      l->current = l->current->next;
    }
  }
  l->currentPos = newPos;
}

//
void ListMoveToNext(List* l) {
  ListMove(l, l->currentPos < l->size - 1 ? l->currentPos + 1 : -1);
}

void ListMoveToPrevious(List* l) {
  ListMove(l, l->currentPos >= 0 ? l->currentPos - 1 : l->size - 1);
}

void ListMoveToHead(List* l) { ListMove(l, 0); }

void ListMoveToTail(List* l) { ListMove(l, l->size - 1); }

//
// Estratégia de comparaçao um pouco diferente da testada
// Resultado é o mesmo apesar do numero de comparaçoes variar
// ^

int ListSearch(List* l, const void* p) {
  int counter = 0;
  struct _ListNode* node = l->head;

  int comp = l->compare(l->current->item, p);
  if (comp <= 0) {
    node = l->current;
    counter = l->currentPos;
  } else {
    comp = l->compare(node->item, p);
  }

  while (comp <= 0) {
    if (comp == 0) {
      ListMove(l, counter);
      return 0;
    }
    node = node->next;
    counter++;
    if (node == NULL) return -1;
    comp = l->compare(node->item, p);
  }
  return -1;
}

int ListInsert(List* l, void* p) {
  struct _ListNode* sn = (struct _ListNode*)malloc(sizeof(struct _ListNode));
  if (sn == NULL) abort();
  sn->item = p;
  sn->next = NULL;

  if (l->size == 0) {
    l->head = l->tail = sn;
    l->size = 1;
    return 0;
  }

  struct _ListNode* prev = NULL;
  struct _ListNode* aux = l->head;
  int i = 0;
  while (i < l->size && l->compare(p, aux->item) > 0) {
    prev = aux;
    aux = aux->next;
    i++;
  }

  if (i == l->size) {
    l->tail->next = sn;
    l->tail = sn;
    l->size++;
    return 0;
  }

  if (l->compare(p, aux->item) == 0) {
    free(sn);
    return -1;
  }

  sn->next = aux;
  if (i == 0)
    l->head = sn;
  else
    prev->next = sn;
  if (l->currentPos >= i) l->currentPos++;
  l->size++;
  return 0;
}

void* ListRemoveHead(List* l) {
  assert(l->size > 0);
  void* item = l->head->item;
  struct _ListNode* sn = l->head->next;
  if (l->current == l->head) {
    l->current = sn;
    if (l->current == NULL) l->currentPos = -1;
  }
  free(l->head);
  l->head = sn;
  if (l->size == 1) {
    l->tail = NULL;
  }
  l->size--;
  return item;
}

void* ListRemoveTail(List* l) {
  assert(l->size > 0);
  if (l->current == l->tail) {
    l->current = NULL;
    l->currentPos = -1;
  }
  void* item = l->tail->item;
  struct _ListNode* sn = NULL;
  if (l->size == 1) {
    l->head = NULL;
  } else {
    sn = l->head;
    while (sn->next != l->tail) sn = sn->next;
    sn->next = NULL;
  }
  free(l->tail);
  l->tail = sn;
  l->size--;
  return item;
}

void* ListRemoveCurrent(List* l) {
  assert(ListCurrentIsInside(l));
  void* item = l->current->item;
  if (l->currentPos == 0)
    item = ListRemoveHead(l);
  else if (l->currentPos == l->size - 1)
    item = ListRemoveTail(l);
  else {
    struct _ListNode* prev = l->head;
    for (int i = 0; i < l->currentPos - 1; i++) {
      prev = prev->next;
    }
    prev->next = l->current->next;
    free(l->current);
    l->current = prev->next;
    l->size--;
  }
  return item;
}

void ListTestInvariants(const List* l) {
  assert(l->size >= 0);

  assert((l->size == 0) == (l->head == NULL));
  assert((l->size == 0) == (l->tail == NULL));

  assert((l->size <= 1) == (l->head == l->tail));

  assert(-1 <= l->currentPos && l->currentPos < l->size);

  assert((l->currentPos == -1) == (l->current == NULL));
  struct _ListNode* sn = l->head;
  for (int i = 0; i < l->size; i++) {
    if (i < l->size - 1)
      assert(sn->next != NULL);
    else
      assert(sn == l->tail && sn->next == NULL);
    if (i == l->currentPos) assert(sn == l->current);
    sn = sn->next;
  }
}
