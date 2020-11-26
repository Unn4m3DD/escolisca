#include <BST.h>
#include <malloc.h>

BST* bst_instanteate(int (*comparator)(void*, void*)) {
  BST* instance = (BST*)malloc(sizeof(BST));
  instance->comparator = comparator;
  instance->root = NULL;
  instance->size = 0;
  return instance;
}
void bst_destroy(BST** bst_ptr) {
  bst_clear(*bst_ptr);
  free(*bst_ptr);
  bst_ptr = NULL;
}

int bst_add_rec(BST_node* root, void* elem, int (*comparator)(void*, void*)) {
  int comp = comparator(elem, root->content);
  if (comp == 0) return 0;

  if (comp < 0) {
    if (root->left == NULL) {
      root->left = (BST_node*)malloc(sizeof(BST_node));
      root->left->content = elem;
      root->left->right = NULL;
      root->left->left = NULL;
      return 1;
    }
    return bst_add_rec(root->left, elem, comparator);
  }

  if (comp > 0) {
    if (root->right == NULL) {
      root->right = (BST_node*)malloc(sizeof(BST_node));
      root->right->content = elem;
      root->right->right = NULL;
      root->right->left = NULL;
      return 1;
    }
    return bst_add_rec(root->right, elem, comparator);
  }

  return 0;
}

int bst_add(BST* bst, void* elem) {
  int result = 1;
  if (bst->root == NULL) {
    bst->root = (BST_node*)malloc(sizeof(BST_node));
    bst->root->content = elem;
    bst->root->right = NULL;
    bst->root->left = NULL;
  } else
    result = bst_add_rec(bst->root, elem, bst->comparator);
  if (result == 1)
    bst->size++;
  return result;
}

void bst_clear_rec(BST_node* root) {
  BST_node* left = root->left;
  BST_node* right = root->right;
  if (left != NULL) bst_clear_rec(left);
  if (right != NULL) bst_clear_rec(right);
  free(root);
}

void bst_clear(BST* bst) {
  bst_clear_rec((bst)->root);
  bst->size = 0;
  bst->root = NULL;
}

BST* bst_clone(BST* bst) {
  //TODO
  return NULL;
}

int bst_contains_rec(BST_node* root, void* elem, int (*comparator)(void*, void*)) {
  if (root == NULL) return 0;
  int comp = comparator(root->content, elem);
  if (comp == 0) return 1;
  if (comp < 0) return bst_contains_rec(root->left, elem, comparator);
  if (comp > 0) return bst_contains_rec(root->right, elem, comparator);
  return 0;
}

int bst_contains(BST* bst, void* elem) {
  return bst_contains_rec(bst->root, elem, bst->comparator);
}

void* bst_max(BST* bst) {
  BST_node* current = bst->root;
  while (current->left != NULL) {
    current = current->left;
  }
  return current->content;
}

void* bst_min(BST* bst) {
  BST_node* current = bst->root;
  while (current->right != NULL) {
    current = current->right;
  }
  return current->content;
}

int bst_is_empty(BST* bst) {
  return bst->size == 0;
}

void* bst_remove(BST* bst) {
  //TODO
  return NULL;
}

int bst_size(BST* bst) {
  return bst->size;
}

void bst_traverse_in_order_rec(BST_node* root, void (*apply)(void*)) {
  if (root->left != NULL)
    bst_traverse_in_order_rec(root->left, apply);
  apply(root->content);
  if (root->right != NULL)
    bst_traverse_in_order_rec(root->right, apply);
}

void bst_traverse_in_order(BST* bst, void (*apply)(void*)) {
  bst_traverse_in_order_rec(bst->root, apply);
}

void bst_traverse_pre_order_rec(BST_node* root, void (*apply)(void*)) {
  apply(root->content);
  if (root->left != NULL)
    bst_traverse_in_order_rec(root->left, apply);
  if (root->right != NULL)
    bst_traverse_in_order_rec(root->right, apply);
}

void bst_traverse_pre_order(BST* bst, void (*apply)(void*)) {
  bst_traverse_pre_order_rec(bst->root, apply);
}

void bst_traverse_post_order_rec(BST_node* root, void (*apply)(void*)) {
  if (root->left != NULL)
    bst_traverse_in_order_rec(root->left, apply);
  if (root->right != NULL)
    bst_traverse_in_order_rec(root->right, apply);
  apply(root->content);
}

void bst_traverse_post_order(BST* bst, void (*apply)(void*)) {
  bst_traverse_post_order_rec(bst->root, apply);
}

void bst_traverse_breadth(BST* bst, void (*apply)(void*)) {
  BST_node** stack = (BST_node**)malloc(sizeof(BST_node) * bst->size);
  int current = 1;
  stack[0] = bst->root;
  do {
    current--;
    BST_node* node = stack[current];
    apply(node->content);
    if (node->right != NULL)
      stack[current++] = node->right;
    if (node->left != NULL)
      stack[current++] = node->left;
  } while (current != 0);
  free(stack);
}

void bst_alter_in_order(BST* bst, void* (*apply)(void*));

void bst_alter_pre_order(BST* bst, void* (*apply)(void*));

void bst_alter_post_order(BST* bst, void* (*apply)(void*));

void bst_alter_breadth(BST* bst, void* (*apply)(void*));
