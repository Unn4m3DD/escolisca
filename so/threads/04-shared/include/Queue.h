#include <pthread.h>
#include <stdint.h>
#define MAX_QUEUE_SIZE 50
class Queue {
 private:
  uint32_t size = MAX_QUEUE_SIZE;
  uint32_t content[MAX_QUEUE_SIZE];
  uint32_t head = 0;
  uint32_t tail = 0;
  pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
  pthread_cond_t isNotEmptyCondition = PTHREAD_COND_INITIALIZER;
  uint32_t usedSpace = 0;
 public:
  uint32_t retrieve();
  void insert(uint32_t item);
  bool isEmpty();
};