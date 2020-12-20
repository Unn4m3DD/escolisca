#pragma once
#include "queue.h"
#include "buffer.h"

typedef struct {
  queue_t* free_queue;
  queue_t* pending_queue;
  buffer_t* buffer_pool;
} state_t;