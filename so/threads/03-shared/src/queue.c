#include "queue.h"

#include "buffer.h"
int queue_get(queue_t* queue) {
  pthread_mutex_lock(&queue->lock);
  while(queue->size == 0)
    pthread_cond_wait(&queue->is_empty_condition, &queue->lock);
  int result = queue->ids[queue->first];
  queue->first = (queue->first + 1) % QUEUE_MAX_SIZE;
  queue->size--;
  pthread_mutex_unlock(&queue->lock);
  return result;
}

int queue_peek(queue_t* queue) {
  return queue->ids[queue->first];
}

int queue_add(queue_t* queue, int item) {
  pthread_mutex_lock(&queue->lock);
  queue->ids[queue->last] = item;
  queue->last = (queue->last + 1) % QUEUE_MAX_SIZE;
  queue->size++;
  pthread_cond_broadcast(&queue->is_empty_condition);
  pthread_mutex_unlock(&queue->lock);
}

queue_t* queue_create() {
  queue_t* result = malloc(sizeof(queue_t));
  result->first = 0;
  result->last = 0;
  result->size = 0;
  memset(result->ids, QUEUE_MAX_SIZE, 0);
  pthread_mutex_init(&result->lock, NULL);
  pthread_cond_init(&result->is_empty_condition, NULL);
  return result;
}
