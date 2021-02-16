#include <Queue.h>
uint32_t Queue::retrieve() {
  pthread_mutex_lock(&this->lock);
  while (this->isEmpty())
    pthread_cond_wait(&this->isNotEmptyCondition, &this->lock);

  uint32_t result = this->content[tail];
  tail = (tail + 1) % this->size;
  usedSpace--;
  pthread_mutex_unlock(&this->lock);
  return result;
}

void Queue::insert(uint32_t item) {
  pthread_mutex_lock(&this->lock);
  this->content[head] = item;
  head = (head + 1) % this->size;
  usedSpace++;
  pthread_cond_signal(&this->isNotEmptyCondition);
  pthread_mutex_unlock(&this->lock);
}

bool Queue::isEmpty() {
  return usedSpace == 0;
}
