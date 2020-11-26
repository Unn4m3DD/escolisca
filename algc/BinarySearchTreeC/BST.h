#pragma once

typedef struct BST_node {
  void* content;
  BST_node* left;
  BST_node* right;
} BST_node;

typedef struct BST {
  int size;
  BST_node* root;
  int (*comparator)(void*, void*);
} BST;

/* Creates an empty binary search tree and returns a pointer to it*/
BST* bst_instanteate(int (*comparator)(void*, void*));

/* Destroys the tree*/
void bst_destroy(BST** bst_ptr);

/* Adds an element to the tree, returns a boolean indicating if it was successful or not */
int bst_add(BST* bst, void* elem);

/* Clears all the binary search tree, maintaining allocated a pointer to it*/
void bst_clear(BST* bst);

/* Returns a pointer to a cloned tree, does not clone de objects pointed */
BST* bst_clone(BST* bst);

/* Returns a boolean indicating if the object exists or not in the tree*/
int bst_contains(BST* bst, void* elem);

/* Returns the maximum of the tree based on the comparisson function passed to the constructor*/
void* bst_max(BST* bst);

/* Returns the minimum of the tree based on the comparisson function passed to the constructor*/
void* bst_min(BST* bst);

/* Returns a boolean indicating if the tree is empty or not*/
int bst_is_empty(BST* bst);

/* Removes an element from the tree, returns a pointer to the removed element*/
void* bst_remove(BST* bst);

/* Returns the number of elements of the tree*/
int bst_size(BST* bst);

/* Traverses the tree in order and applies a function to all elements*/
void bst_traverse_in_order(BST* bst, void (*apply)(void*));

/* Traverses the tree in pre order and applies a function to all elements*/
void bst_traverse_pre_order(BST* bst, void (*apply)(void*));

/* Traverses the tree in post order and applies a function to all elements*/
void bst_traverse_post_order(BST* bst, void (*apply)(void*));

/* Traverses the tree in breadth and applies a function to all elements*/
void bst_traverse_breadth(BST* bst, void (*apply)(void*));

/* Traverses the tree in order and applies a function to all elements storing the results*/
void bst_alter_in_order(BST* bst, void* (*apply)(void*));

/* Traverses the tree in pre order and applies a function to all elements storing the results*/
void bst_alter_pre_order(BST* bst, void* (*apply)(void*));

/* Traverses the tree in post order and applies a function to all elements storing the results*/
void bst_alter_post_order(BST* bst, void* (*apply)(void*));

/* Traverses the tree in breadth and applies a function to all elements storing the results*/
void bst_alter_breadth(BST* bst, void* (*apply)(void*));
