#include <string.h>

#include <iostream>

#include "Queue.h"
#include "StringGen.h"
#define STRING_MAX_SIZE 20
#define CLIENT_COUNT 1
#define SERVER_COUNT 1
using namespace std;
static Queue freeBuffers;
static Queue pendingRequests;

class Buffer {
 public:
  char toProcess[STRING_MAX_SIZE];
  uint32_t length;
  uint32_t numberCount;
  uint32_t charCount;
  pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
  pthread_cond_t readyCond = PTHREAD_COND_INITIALIZER;
  bool isReady = false;
  void print() {
    cout << toProcess << ", " << length << ", " << numberCount << ", " << charCount << endl;
  }
};

Buffer buffers[MAX_QUEUE_SIZE];

void processData(uint32_t id) {
  Buffer* currentBuffer = &buffers[id];
  char* currentChar = currentBuffer->toProcess;
  while (*currentChar != 0) {
    if (
        ('a' <= *currentChar && *currentChar <= 'z') ||
        ('A' <= *currentChar && *currentChar <= 'Z'))
      currentBuffer->charCount++;
    if ('0' <= *currentChar && *currentChar <= '9')
      currentBuffer->numberCount++;
    currentBuffer->length++;
    currentChar++;
  }
}

void* server(void* args) {
  while (1) {
    uint32_t id = pendingRequests.retrieve();
    pthread_mutex_lock(&buffers[id].lock);
    processData(id);
    buffers[id].isReady = true;
    pthread_mutex_unlock(&buffers[id].lock);
    pthread_cond_signal(&buffers[id].readyCond);
  }
}

void* client(void* args) {
  while (1) {
    uint32_t id = freeBuffers.retrieve();
    GenerateRandomString(rand() % 10 + STRING_MAX_SIZE - 10, buffers[id].toProcess);
    pendingRequests.insert(id);
    Buffer* currentBuffer = &buffers[id];
    pthread_mutex_lock(&currentBuffer->lock);
    while (!currentBuffer->isReady) {
      pthread_cond_wait(&currentBuffer->readyCond, &currentBuffer->lock);
    }
    currentBuffer->print();
    currentBuffer->isReady = false;
    memset(&currentBuffer->toProcess, 0, STRING_MAX_SIZE);
    currentBuffer->length = 0;
    currentBuffer->numberCount = 0;
    currentBuffer->charCount = 0;
    freeBuffers.insert(id);
    pthread_mutex_unlock(&currentBuffer->lock);
  }
}

int main() {
  for (uint i = 0; i < MAX_QUEUE_SIZE; i++)
    freeBuffers.insert(i);
  pthread_t clients[CLIENT_COUNT];
  pthread_t servers[SERVER_COUNT];

  for (uint i = 0; i < CLIENT_COUNT; i++)
    pthread_create(&clients[i], NULL, client, NULL);
  for (uint i = 0; i < SERVER_COUNT; i++)
    pthread_create(&servers[i], NULL, server, NULL);

  for (uint i = 0; i < CLIENT_COUNT; i++)
    pthread_join(clients[i], NULL);
  for (uint i = 0; i < SERVER_COUNT; i++)
    pthread_join(servers[i], NULL);
  return 0;
}