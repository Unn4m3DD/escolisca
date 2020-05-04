// NMEC: 92257

// Complete the functions (marked by ...)
// so that it passes all tests in DateTimeTest.

#include "SchedulingSequence.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "TimeInterval.h"

// Create a SchedulingSequence capable of storing up to (capacity) intervals.
SchedulingSequence* SchedulingSequenceCreate(int capacity) {
  assert(capacity >= 0);
  // You must allocate space for the struct and for the intervals array!
  SchedulingSequence* instance =
      (SchedulingSequence*)malloc(sizeof(SchedulingSequence));
  instance->capacity = capacity;
  instance->size = 0;
  instance->intervals =
      (TimeInterval**)malloc(capacity * sizeof(TimeInterval*));
  return instance;
}

// Destroy SchedulingSequence *pss
void SchedulingSequenceDestroy(SchedulingSequence** pss) {
  assert(*pss != NULL);
  free((*pss)->intervals);
  free(*pss);
  *pss = NULL;
}

int SchedulingSequenceIsEmpty(SchedulingSequence* ss) { return ss->size == 0; }

int SchedulingSequenceIsFull(SchedulingSequence* ss) {
  return ss->size == ss->capacity;
}

void swap(TimeInterval** t1, TimeInterval** t2) {
  TimeInterval* tmp = *t1;
  *t1 = *t2;
  *t2 = tmp;
}
void shiftArray(TimeInterval** array, int first, int last) {
  for (int i = last - 2; i >= first; i--) {
    swap(&(array[i]), &(array[i + 1]));
  }
}
void unShiftArray(TimeInterval** array, int first, int last) {
  for (int i = first; i < last - 1; i++) {
    swap(&(array[i]), &(array[i + 1]));
  }
}
#define PRINTSS(X)                                          \
  printf("[");                                              \
  for (int i = 0; i < ss->size; i++) {                      \
    printf("\n  %s,", TimeIntervalFormat(X->intervals[i])); \
  }                                                         \
  puts("\n]");

// Add interval *ti to *ss.
// Return true on success,
// return false if *ti overlaps any of the intervals in *ss.
int SchedulingSequenceAdd(SchedulingSequence* ss, TimeInterval* ti) {
  assert(!SchedulingSequenceIsFull(ss));
  ss->intervals[ss->size] = ti;
  ss->size++;
  if (ss->size == 1) {
    return 1;
  }

  for (int i = ss->size - 2; i >= 0; i--) {
    int comp = TimeIntervalCompare(ti, ss->intervals[i]);
    if (comp == 0) {
      ss->size--;
      return 0;
    }
    if (comp > 0) {
      printf("i = %d, size = %d\n", i + 1, ss->size);
      shiftArray(ss->intervals, i + 1, ss->size);
      return 1;
    }
  }
  shiftArray(ss->intervals, 0, ss->size);

  return 1;
}

// Get the interval at position (idx) of *ss.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval* SchedulingSequenceGet(SchedulingSequence* ss, int idx) {
  assert(0 <= idx && idx < ss->size);
  return ss->intervals[idx];
}

// Remove the interval at position (idx) of *ss, and return it.
// idx=0 is the first position idx=ss->size-1 is the last position.
// Precondition: 0 <= idx < ss->size.
TimeInterval* SchedulingSequencePop(SchedulingSequence* ss, int idx) {
  assert(0 <= idx && idx < ss->size);
  // This implies !SchedulingSequenceIsEmpty(ss).
  TimeInterval* result = ss->intervals[idx];
  unShiftArray(ss->intervals, idx, ss->size);
  ss->size--;

  return result;
}
