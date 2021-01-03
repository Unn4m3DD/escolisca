/*
 *  @brief A simple FIFO, whose elements are pairs of integers,
 *      one being the id of the producer and the other the value produced
 *
 * @remarks Unsafe, blocking, busy waiting version
 *
 *  The following operations are defined:
 *     \li insertion of a value
 *     \li retrieval of a value.
 *
 * \author (2016) Artur Pereira <artur at ua.pt>
 */

#include <errno.h>
#include <stdbool.h>
#include <stdio.h>
#include <unistd.h>

#include "delays.h"
#include "fifo.h"

/** \brief internal storage size of <em>FIFO memory</em> */
#define FIFOSZ 5

/*
 *  \brief Data structure.
 */
typedef struct ITEM {
  unsigned int id;     ///< id of the producer
  unsigned int value;  ///< value stored
} ITEM;

typedef struct FIFO {
  unsigned int ii;    ///< point of insertion
  unsigned int ri;    ///< point of retrieval
  unsigned int cnt;   ///< number of items stored
  ITEM slot[FIFOSZ];  ///< storage memory
} FIFO;

/** \brief internal storage region of FIFO type */
static FIFO fifo;

/* ************************************************* */

/* Initialization of the FIFO */
void fifoInit(void) {
  unsigned int i;
  for (i = 0; i < FIFOSZ; i++) {
    fifo.slot[i].id = 99999999;
    fifo.slot[i].value = 99999999;
  }
  fifo.ii = fifo.ri = 0;
  fifo.cnt = 0;
}

/* ************************************************* */

/* Check if FIFO is full */
static bool fifoFull(void) {
  return fifo.cnt == FIFOSZ;
}

/* ************************************************* */

/* Check if FIFO is empty */
static bool fifoEmpty(void) {
  return fifo.cnt == 0;
}

/* ************************************************* */

/* Insertion of a pair <id, value> into the FIFO  */
void fifoIn(unsigned int id, unsigned int value) {
  /* wait while fifo is full */
  while (fifoFull()) {
    usleep(1000);
  }

  /* Insert pair */
  fifo.slot[fifo.ii].value = value;
  gaussianDelay(1, 0.5);
  fifo.slot[fifo.ii].id = id;
  fifo.ii = (fifo.ii + 1) % FIFOSZ;
  fifo.cnt++;
}

/* ************************************************* */

/* Retrieval of a pair <id, value> from the FIFO */

void fifoOut(unsigned int* idp, unsigned int* valuep) {
  /* wait while fifo is empty */
  while (fifoEmpty()) {
    usleep(1000);
  }

  /* Retrieve pair */
  *valuep = fifo.slot[fifo.ri].value;
  fifo.slot[fifo.ri].value = 99999999;
  *idp = fifo.slot[fifo.ri].id;
  fifo.slot[fifo.ri].id = 99999999;
  fifo.ri = (fifo.ri + 1) % FIFOSZ;
  fifo.cnt--;
}

/* ************************************************* */
