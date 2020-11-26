

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Date.h"

#define SHOWint(X)                 \
  do {                             \
    printf("%s -> %d\n", #X, (X)); \
  } while (0)

#define SHOWstr(X)                 \
  do {                             \
    printf("%s -> %s\n", #X, (X)); \
  } while (0)

#define SHOWDate(X)                               \
  do {                                            \
    printf("%s -> %s\n", #X, DateFormat(X, YMD)); \
  } while (0)

#ifndef SIGNUMFUNC
#define SIGNUMFUNC ;
int signum(int d) { return (d > 0) - (d < 0); }
#endif

int mainDate(int argc, char* argv[]) {
  int lasttest = 9999;
  if (argc > 1) {
    lasttest = atoi(argv[1]);
  }
  int test = 0;

  printf("\n%d) Date Constants---\n", test);
  SHOWDate(&DateMIN);
  SHOWDate(&DateMAX);

  printf("\n%d) Date Automatic Variables---\n", test);

  Date dd0 = {1999, 9, 9};
  SHOWDate(&dd0);
  Date dd1 = {1999, 9, 31};
  SHOWDate(&dd1);

  SHOWint(dd0.year);
  SHOWint(dd0.month);
  SHOWint(dd0.day);

  dd1.day = 0;

  if (++test > lasttest) return 0;
  printf("\n%d) DateCreate---\n", test);

  Date* d1 = DateCreate(2019, 12, 25);
  SHOWDate(d1);

  Date* d2 = DateCreate(2020, 3, 2);
  SHOWDate(d2);
  assert(d2 != d1);
  SHOWDate(d1);

  if (++test > lasttest) return 0;
  printf("\n%d) DateDestroy---\n", test);
  DateDestroy(&d2);
  SHOWDate(d2);
  assert(d2 == NULL);
  d2 = DateCreate(2020, 5, 1);
  SHOWDate(d1);
  SHOWDate(d2);

  if (++test > lasttest) return 0;
  printf("\n%d) DateFormat---\n", test);
  SHOWstr(DateFormat(d1, YMD));
  SHOWstr(DateFormat(d1, DMY));
  SHOWstr(DateFormat(d1, MDY));

  printf("d1 -> %s  d2 -> %s\n", DateFormat(d1, YMD), DateFormat(d2, YMD));

  if (++test > lasttest) return 0;
  printf("\n%d) DateParse---\n", test);
  Date* d3 = DateParse("1111-2-3", YMD);
  SHOWDate(d3);
  Date* d4 = DateParse("11/2/3333", DMY);
  SHOWDate(d4);
  Date* d5 = DateParse("11/22/3333", MDY);
  SHOWDate(d5);

  DateDestroy(&d3);
  DateDestroy(&d4);
  DateDestroy(&d5);

  if (++test > lasttest) return 0;
  printf("\n%d) DateCompare---\n", test);
  SHOWint(signum(DateCompare(d1, d1)));
  SHOWint(signum(DateCompare(d1, d2)));
  SHOWint(signum(DateCompare(d2, d1)));
  SHOWint(signum(DateCompare(d2, d2)));

  if (++test > lasttest) return 0;
  dd0 = *d1;
  printf("\n%d) DateIncr---\n", test);
  while (DateCompare(d1, d2) <= 0) {
    SHOWDate(d1);
    DateIncr(d1);
  }

  if (++test > lasttest) return 0;
  *d2 = dd0;
  printf("\n%d) DateDecr---\n", test);
  while (DateCompare(d1, d2) >= 0) {
    SHOWDate(d1);
    DateDecr(d1);
  }

  DateDestroy(&d1);
  DateDestroy(&d2);

  return 0;
}
