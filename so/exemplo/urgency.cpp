/**
 * @file
 *
 * \brief A hospital pediatric urgency with a Manchester triage system.
 */

#include <libgen.h>
#include <math.h>
#include <signal.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <thread.h>
#include <unistd.h>
#include <utils.h>

#include "pfifo.h"
#include "settings.h"

//#include "thread.h"
//#include "process.h"

#include <iostream>

#define USAGE                                                  \
  "Synopsis: %s [options]\n"                                   \
  "\t----------+-------------------------------------------\n" \
  "\t  Option  |          Description                      \n" \
  "\t----------+-------------------------------------------\n" \
  "\t -p num   | number of patients (dfl: 4)               \n" \
  "\t -n num   | number of nurses (dfl: 1)                 \n" \
  "\t -d num   | number of doctors (dfl: 1)                \n" \
  "\t -h       | this help                                 \n" \
  "\t----------+-------------------------------------------\n"

/**
 * \brief Patient data structure
 */
typedef struct
{
  char name[MAX_NAME + 1];
  int done;  // 0: waiting for consultation; 1: consultation finished
  pthread_mutex_t lock;
  pthread_cond_t is_done;
} Patient;

typedef struct
{
  int num_patients;
  Patient all_patients[MAX_PATIENTS];
  PriorityFIFO triage_queue;
  PriorityFIFO doctor_queue;
} HospitalData;

HospitalData* hd = NULL;

/**
 *  \brief patient verification test
 */
#define check_valid_patient(id)                  \
  do {                                           \
    check_valid_id(id);                          \
    check_valid_name(hd->all_patients[id].name); \
  } while (0)

int random_manchester_triage_priority();
void new_patient(Patient* patient);  // initializes a new patient
void random_wait();

/* ************************************************* */

/* changes may be required to this function */
void init_simulation(uint32_t np) {
  printf("Initializing simulation\n");
  hd = (HospitalData*)mem_alloc(sizeof(HospitalData));  // mem_alloc is a calloc with NULL pointer verification
  memset(hd, 0, sizeof(HospitalData));
  hd->num_patients = np;
  init_pfifo(&hd->triage_queue);
  init_pfifo(&hd->doctor_queue);
}

void* patient_interation(void* args) {
  Patient* patient = &hd->all_patients[(int)(long)args];
  pthread_mutex_lock(&patient->lock);
  while (patient->done == 0)
    pthread_cond_wait(&patient->is_done, &patient->lock);
    //TODO Completar com logica de ingresso nas 2 queues
  return NULL;
}
/* ************************************************* */

void* nurse_iteration(void* args) {
  printf("\e[34;01mNurse: get next patient\e[0m\n");
  uint32_t patient_id = retrieve_pfifo(&hd->triage_queue);
  Patient* patient = &hd->all_patients[patient_id];
  pthread_mutex_lock(&patient->lock);
  check_valid_patient(patient_id);
  printf("\e[34;01mNurse: evaluate patient %u priority\e[0m\n", patient_id);
  uint32_t priority = random_manchester_triage_priority();
  printf("\e[34;01mNurse: add patient %u with priority %u to doctor queue\e[0m\n", patient_id, priority);
  insert_pfifo(&hd->doctor_queue, patient_id, priority);
  pthread_cond_signal(&patient->is_done);
  pthread_mutex_unlock(&patient->lock);
  return NULL;
}

/* ************************************************* */

void* doctor_iteration(void* args) {
  printf("\e[32;01mDoctor: get next patient\e[0m\n");
  uint32_t patient_id = retrieve_pfifo(&hd->triage_queue);
  Patient* patient = &hd->all_patients[patient_id];
  check_valid_patient(patient_id);
  printf("\e[32;01mDoctor: treat patient %u\e[0m\n", patient_id);
  random_wait();
  printf("\e[32;01mDoctor: patient %u treated\e[0m\n", patient_id);
  hd->all_patients[patient_id].done = 1;
  pthread_cond_signal(&patient->is_done);
  pthread_mutex_unlock(&patient->lock);
  return NULL;
}

/* ************************************************* */

void patient_goto_urgency(int id) {
  new_patient(&hd->all_patients[id]);
  check_valid_name(hd->all_patients[id].name);
  printf("\e[30;01mPatient %s (number %u): get to hospital\e[0m\n", hd->all_patients[id].name, id);
  insert_pfifo(&hd->triage_queue, id, 1);  // all elements in triage queue with the same priority!
}

/* changes may be required to this function */
void patient_wait_end_of_consultation(int id) {
  check_valid_name(hd->all_patients[id].name);
  printf("\e[30;01mPatient %s (number %u): health problems treated\e[0m\n", hd->all_patients[id].name, id);
}

/* changes are required to this function */
void patient_life(int id) {
  patient_goto_urgency(id);
  //nurse_iteration();   // to be deleted in concurrent version
  //doctor_iteration();  // to be deleted in concurrent version
  patient_wait_end_of_consultation(id);
  memset(&(hd->all_patients[id]), 0, sizeof(Patient));  // patient finished
}

/* ************************************************* */

int main(int argc, char* argv[]) {
  uint32_t npatients = 4;  ///< number of patients
  uint32_t nnurses = 1;    ///< number of triage nurses
  uint32_t ndoctors = 1;   ///< number of doctors

  /* command line processing */
  int option;
  while ((option = getopt(argc, argv, "p:n:d:h")) != -1) {
    switch (option) {
      case 'p':
        npatients = atoi(optarg);
        if (npatients < 1 || npatients > MAX_PATIENTS) {
          fprintf(stderr, "Invalid number of patients!\n");
          return EXIT_FAILURE;
        }
        break;
      case 'n':
        nnurses = atoi(optarg);
        if (nnurses < 1) {
          fprintf(stderr, "Invalid number of nurses!\n");
          return EXIT_FAILURE;
        }
        break;
      case 'd':
        ndoctors = atoi(optarg);
        if (ndoctors < 1) {
          fprintf(stderr, "Invalid number of doctors!\n");
          return EXIT_FAILURE;
        }
        break;
      case 'h':
        printf(USAGE, basename(argv[0]));
        return EXIT_SUCCESS;
      default:
        fprintf(stderr, "Non valid option!\n");
        fprintf(stderr, USAGE, basename(argv[0]));
        return EXIT_FAILURE;
    }
  }

  pthread_t* nurse_threads = (pthread_t*)alloca(sizeof(pthread_t) * nnurses);
  pthread_t* doctor_threads = (pthread_t*)alloca(sizeof(pthread_t) * ndoctors);

  /* start random generator */
  srand(getpid());

  /* init simulation */
  init_simulation(npatients);

  for (uint32_t i = 0; i < nnurses; i++) {
    pthread_create(&nurse_threads[i], NULL, nurse_iteration, NULL);
  }
  for (uint32_t i = 0; i < ndoctors; i++) {
    pthread_create(&doctor_threads[i], NULL, doctor_iteration, NULL);
  }

  for (uint32_t i = 0; i < nnurses; i++) {
    pthread_join(nurse_threads[i], NULL);
  }
  for (uint32_t i = 0; i < ndoctors; i++) {
    pthread_join(doctor_threads[i], NULL);
  }
  /* dummy code to show a very simple sequential behavior */
  // for (uint32_t i = 0; i < npatients; i++) {
  //   printf("\n");
  //   random_wait();  // random wait for patience creation
  //   patient_life(i);
  // }

  return EXIT_SUCCESS;
}

/* YOU MAY IGNORE THE FOLLOWING CODE */

int random_manchester_triage_priority() {
  int result;
  int perc = (int)(100 * (double)rand() / ((double)RAND_MAX));  // in [0;100]
  if (perc < 10)
    result = RED;
  else if (perc < 30)
    result = ORANGE;
  else if (perc < 50)
    result = YELLOW;
  else if (perc < 75)
    result = GREEN;
  else
    result = BLUE;
  return result;
}

static char** names = (char*[]){"Ana", "Miguel", "Luis", "Joao", "Artur", "Maria", "Luisa", "Mario", "Augusto", "Antonio", "Jose", "Alice", "Almerindo", "Gustavo", "Paulo", "Paula", NULL};

char* random_name() {
  static int names_len = 0;
  if (names_len == 0) {
    for (names_len = 0; names[names_len] != NULL; names_len++)
      ;
  }

  return names[(int)(names_len * (double)rand() / ((double)RAND_MAX + 1))];
}

void new_patient(Patient* patient) {
  strcpy(patient->name, random_name());
  patient->done = 0;
}

void random_wait() {
  usleep((useconds_t)(MAX_WAIT * (double)rand() / (double)RAND_MAX));
}
