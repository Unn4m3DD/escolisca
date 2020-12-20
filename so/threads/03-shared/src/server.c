#include "buffer.h"
#include "queue.h"
#include "random_string.h"
#include "main.h"
void* server_main_loop(void* state) {
  queue_t* free_queue = ((state_t*)state)->free_queue;
  queue_t* pending_queue = ((state_t*)state)->pending_queue;
  buffer_t* buffer_pool = ((state_t*)state)->buffer_pool;
  while (1) {
    int id = queue_get(pending_queue);
    buffer_t* current_buffer = &buffer_pool[id];
    pthread_mutex_lock(&current_buffer->lock);
    buffer_process(current_buffer);
    current_buffer->processed = true;
    pthread_cond_signal(&current_buffer->processed_condition);
    pthread_mutex_unlock(&current_buffer->lock);
  }
  return NULL;
}
