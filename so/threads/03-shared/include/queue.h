#pragma once
#define QUEUE_MAX_SIZE 10
#include <pthread.h>
#include <string.h>
#include <malloc.h>
typedef struct {
  int ids[QUEUE_MAX_SIZE];
  int first;
  int last;
  pthread_mutex_t lock;
  pthread_cond_t is_empty_condition;
  int size;
} queue_t;

queue_t* queue_create();
int queue_get(queue_t* queue);
int queue_peek(queue_t* queue);
int queue_add(queue_t* queue, int item);
