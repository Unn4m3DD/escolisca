#pragma once
#include <stdbool.h>
#include <pthread.h>
#include <stdio.h>
#define BUFFER_STR_MAX_SIZE 50
typedef struct {
  int char_count;
  int digit_count;
  int letters_count;
} statistics_t;
typedef struct {
  char to_process[BUFFER_STR_MAX_SIZE];
  statistics_t statistics;
  pthread_mutex_t lock;
  pthread_cond_t processed_condition;
  bool processed;
} buffer_t;

void buffer_process(buffer_t* buffer);
void buffer_print(buffer_t* buffer);
void buffer_clear(buffer_t* buffer);
