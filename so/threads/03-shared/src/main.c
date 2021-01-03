
#include "main.h"

#include <stdio.h>
#include <pthread.h>
#include "client.h"
#include "server.h"
int main() {
  state_t state;
  state.free_queue = queue_create();
  state.pending_queue = queue_create();
  buffer_t buffer_pool[BUFFER_COUNT];
  state.buffer_pool = buffer_pool;
  pthread_t clients[CLIENT_COUNT];
  pthread_t servers[SERVER_COUNT];
  for (int i = 0; i < BUFFER_COUNT; i++) {
    pthread_mutex_init(&buffer_pool[i].lock, NULL);
    pthread_cond_init(&buffer_pool[i].processed_condition, NULL);
    queue_add(state.free_queue, i);
  }
  for (int i = 0; i < CLIENT_COUNT; i++) {
    pthread_create(&clients[i], NULL, client_main_loop, &state);
  }
  for (int i = 0; i < SERVER_COUNT; i++) {
    pthread_create(&servers[i], NULL, server_main_loop, &state);
  }


  for (int i = 0; i < CLIENT_COUNT; i++) {
    pthread_join(clients[i], NULL);
  }
  for (int i = 0; i < SERVER_COUNT; i++) {
    pthread_join(servers[i], NULL);
  }
  free(state.free_queue);
  free(state.pending_queue);
}