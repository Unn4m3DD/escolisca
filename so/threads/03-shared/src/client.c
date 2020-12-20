#include "buffer.h"
#include "main.h"
#include "queue.h"
#include "random_string.h"
void* client_main_loop(void* state) {
  queue_t* free_queue = ((state_t*)state)->free_queue;
  queue_t* pending_queue = ((state_t*)state)->pending_queue;
  buffer_t* buffer_pool = ((state_t*)state)->buffer_pool;
  while (1) {
    int id = queue_get(free_queue);
    buffer_t* current_buffer = &buffer_pool[id];
    random_string(current_buffer->to_process, rand() % 20 + 20);
    queue_add(pending_queue, id);

    pthread_mutex_lock(&current_buffer->lock);
    while (!current_buffer->processed)
      pthread_cond_wait(&current_buffer->processed_condition, &current_buffer->lock);
    buffer_print(current_buffer);
    pthread_mutex_unlock(&current_buffer->lock);
    buffer_clear(current_buffer);
    queue_add(free_queue, id);
  }
  return NULL;
}
