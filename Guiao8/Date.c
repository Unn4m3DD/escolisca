
#include "Date.h"

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

const Date DateMIN = {0, 1, 1};
const Date DateMAX = {9999, 12, 31};

int DateIsValid(int yy, int mm, int dd) {
  return (DateMIN.year) <= yy && yy <= (DateMAX.year) && 1 <= mm && mm <= 12 &&
         1 <= dd && dd <= DateDaysInMonth(yy, mm);
}

static int invariant(Date* d) { return DateIsValid(d->year, d->month, d->day); }

Date* DateCreate(int yy, int mm, int dd) {
  assert(DateIsValid(yy, mm, dd));
  Date* d = (Date*)malloc(sizeof(Date));
  d->day = dd;
  d->month = mm;
  d->year = yy;
  assert(invariant(d));
  return d;
}

void DateDestroy(Date** pd) {
  assert(*pd != NULL);
  free(*pd);
  *pd = NULL;
}

static const uint8_t monthLength[][12] = {
    {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
    {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};

int DateDaysInMonth(int yy, int mm) {
  int isLeap = DateIsLeapYear(yy);
  return monthLength[isLeap][mm - 1];
}

int DateIsLeapYear(int yy) {
  return (yy % 4 == 0 && yy % 100 != 0) || yy % 400 == 0;
}

int DateCompare(const Date* a, const Date* b) {
  if (a->year > b->year) return 1;
  if (a->year < b->year) return -1;
  if (a->month > b->month) return 1;
  if (a->month < b->month) return -1;
  if (a->day > b->day) return 1;
  if (a->day < b->day) return -1;
  return 0;
}

void DateIncr(Date* d) {
  assert(DateCompare(d, &DateMAX) < 0);
  d->day++;
  if (d->day > DateDaysInMonth(d->year, d->month)) {
    d->day = 1;
    d->month++;
    if (d->month > 12) {
      d->month = 1;
      d->year++;
    }
  }
  assert(invariant(d));
}

void DateDecr(Date* d) {
  assert(DateCompare(d, &DateMIN) > 0);
  d->day--;
  if (d->day < 1) {
    d->month--;
    if (d->month < 1) {
      d->month = 12;
      d->year--;
    }
    d->day = DateDaysInMonth(d->year, d->month);
  }

  assert(invariant(d));
}

static char strBuffer[64] = "xx";

static char* fmts[] = {
    (char*)"%04d-%02d-%02d",
    (char*)"%3$02d/%2$02d/%1$04d",
    (char*)"%2$02d/%3$02d/%1$04d",
};

char* DateFormat(const Date* d, int FMT) {
  if (d == NULL)
    snprintf(strBuffer, sizeof(strBuffer), "NULL");
  else
    snprintf(strBuffer, sizeof(strBuffer), fmts[FMT], d->year, d->month,
             d->day);
  return strBuffer;
}

Date* DateParse(const char* str, int FMT) {
  int yy, mm, dd;
  int n = sscanf(str, fmts[FMT], &yy, &mm, &dd);
  Date* d = NULL;
  if (n == 3 && DateIsValid(yy, mm, dd)) {
    d = DateCreate(yy, mm, dd);
  }
  return d;
}
