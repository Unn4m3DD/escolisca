#pragma once
#define BUFFER_COUNT 50
#define SERVER_COUNT 5
#define CLIENT_COUNT 5
#include "queue.h"
#include "buffer.h"

typedef struct {
  queue_t* free_queue;
  queue_t* pending_queue;
  buffer_t* buffer_pool;
} state_t;