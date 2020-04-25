#include "LinkedList.h"

#include <malloc.h>
typedef struct _node Node;
struct _node {
  void* content;
  Node* next;
};

struct _linked_list {
  Node* first;
  Node* last;
  int size;
};
LinkedList* list_instanteate() {
  LinkedList* list = (LinkedList*)malloc(sizeof(LinkedList));
  list->first = NULL;
  list->last = NULL;
  list->size = 0;
  return list;
}
int list_destroy(LinkedList** list) {
  for (Node* node = (*list)->first; node != NULL;) {
    Node* new_node = node->next;
    free(node);
    node = new_node;
  }
  free(*list);
  list = NULL;
  return 1;
}

int list_add(LinkedList* list, void* elem) {
  Node* new_node = (Node*)malloc(sizeof(Node));
  new_node->content = elem;
  list->size++;
  list->last->next = new_node;
  list->last = new_node;
  return 1;
}

int list_insert(LinkedList* list, int index, void* elem) {
  if (index == 0) return list_add_first(list, elem);

  Node* prev_node = list->first;
  for (int i = 1; i < index; i++) {
    prev_node = prev_node->next;
  }
  Node* new_node = (Node*)malloc(sizeof(Node));
  new_node->content = elem;
  new_node->next = prev_node->next;
  prev_node->next = new_node;
  list->size++;
  return 1;
}
int list_add_first(LinkedList* list, void* elem) {
  Node* new_node = (Node*)malloc(sizeof(Node*));
  new_node->next = list->first;
  list->first = new_node;
  list->size++;
  return 1;
}
int list_clear(LinkedList* list) {
  for (Node* node = list->first; node != NULL;) {
    Node* new_node = node->next;
    free(node);
    node = new_node;
  }
  list->size = 0;
  return 1;
}
LinkedList* list_clone(LinkedList* list) {
  LinkedList* new_list = list_instanteate();
  for (Node* node = list->first; node != NULL; node = node->next) {
    list_add(new_list, node->content);
  }
  return new_list;
}

int list_contains(LinkedList* list, void* elem) {
  for (Node* node = list->first; node != NULL; node = node->next) {
    if (node->content == elem) {
      return 1;
    }
  }
  return 0;
}
void* list_get(LinkedList* list, int index) {
  Node* node = list->first;
  for (int i = 0; i < index; i++) {
    node = node->next;
  }
  return node->content;
}
void* list_get_first(LinkedList* list) { return list_get(list, 0); }

void* list_get_last(LinkedList* list) { return list_get(list, list->size); }

int list_index_of(LinkedList* list, void* elem) {
  Node* node = list->first;
  for (int i = 0; i < list->size; i++) {
    if (node->content == elem) return i;
    node = node->next;
  }
  return -1;
}
int list_last_index_of(LinkedList* list, void* elem) {
  int result = -1;
  Node* node = list->first;
  for (int i = 0; i < list->size; i++) {
    if (node->content == elem) result = i;
    node = node->next;
  }
  return result;
}
void* list_remove_index(LinkedList* list, int index) {
  if (index == 0) return list_remove_first(list);
  Node* prev_node = list->first;
  for (int i = 1; i < index; i++) {
    prev_node = prev_node->next;
  }
  Node* to_free_ptr = prev_node->next;
  void* result = to_free_ptr->content;
  prev_node->next = to_free_ptr->next;
  free(to_free_ptr);
  list->size--;
  return result;
}
int list_remove_item(LinkedList* list, void* elem) {
  Node* prev_node;
  for (prev_node = list->first; prev_node->next != NULL;
       prev_node = prev_node->next) {
    if (prev_node->next->content == elem) break;
  }
  if (prev_node->next == NULL) return 0;
  Node* to_free_ptr = prev_node->next;
  prev_node->next = to_free_ptr->next;
  free(to_free_ptr);
  list->size--;
  return 1;
}
void* list_remove_first(LinkedList* list) {
  void* result = list->first->content;
  free(list->first);
  list->first = list->first->next;
  list->size--;
  return result;
}
int list_remove_last_item(LinkedList* list, void* elem) {
  Node* target_node;
  for (Node* prev_node = list->first; prev_node->next != NULL;
       prev_node = prev_node->next) {
    if (prev_node->next->content == elem) target_node = prev_node;
  }
  if (target_node == NULL) return 0;
  Node* to_free_ptr = target_node->next;
  target_node->next = to_free_ptr->next;
  free(to_free_ptr);
  list->size--;
  return 1;
}
void* list_remove_last(LinkedList* list) {
  return list_remove_index(list, list->size - 1);
}
int list_size(LinkedList* list) { return list->size; }
void list_print_int(LinkedList* list) {
  printf("%ld", (long)list->first->content);
  for (Node* node = list->first; node != NULL; node = node->next) {
    printf(" -> %ld", (long)node->content);
  }
}