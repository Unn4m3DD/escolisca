

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>

#include "Time.h"

#define SHOWint(X)                 \
  do {                             \
    printf("%s -> %d\n", #X, (X)); \
  } while (0)

#define SHOWstr(X)                 \
  do {                             \
    printf("%s -> %s\n", #X, (X)); \
  } while (0)

#define SHOWTime(X)                          \
  do {                                       \
    printf("%s -> %s\n", #X, TimeFormat(X)); \
  } while (0)

#ifndef SIGNUMFUNC
#define SIGNUMFUNC

int signum(int d) { return (d > 0) - (d < 0); }
#endif

int main(int argc, char* argv[]) {
  int lasttest = 9999;
  if (argc > 1) {
    lasttest = atoi(argv[1]);
  }
  int test = 0;

  printf("\n%d) Time Constants---\n", test);
  SHOWTime(TimeMIN);
  SHOWTime(TimeMAX);

  if (++test > lasttest) return 0;
  printf("\n%d) TimeCreate---\n", test);

  Time t1 = TimeCreate(8, 30, 0);
  SHOWTime(t1);
  Time t2 = TimeCreate(20, 30, 59);
  SHOWTime(t2);

  if (++test > lasttest) return 0;
  printf("\n%d) Time Getter functions---\n", test);

  SHOWint(TimeGetHH(t1));
  SHOWint(TimeGetMM(t1));
  SHOWint(TimeGetSS(t1));
  SHOWint(TimeGetSeconds(t1));
  SHOWint((int)t1);

  if (++test > lasttest) return 0;
  printf("\n%d) TimeFormat---\n", test);
  SHOWstr(TimeFormat(t1));
  SHOWstr(TimeFormat(t2));

  printf("t1 -> %s  d2 -> %s\n", TimeFormat(t1), TimeFormat(t2));

  if (++test > lasttest) return 0;
  printf("\n%d) TimeParse---\n", test);
  SHOWTime(TimeParse("11:2:3"));
  Time t3 = TimeParse("22:10:63");
  SHOWint(t3 == TimeERR);
  Time t4;
  SHOWTime(t4 = TimeParse("12:30"));
  SHOWint(t4 == TimeParse("12:30:00"));

  if (++test > lasttest) return 0;
  printf("\n%d) TimeCompare---\n", test);
  SHOWint(signum(TimeCompare(t1, t1)));
  SHOWint(signum(TimeCompare(t1, t2)));
  SHOWint(signum(TimeCompare(t2, t1)));
  SHOWint(signum(TimeCompare(t2, t2)));

  SHOWint(t1 < t2);

  if (++test > lasttest) return 0;
  printf("\n%d) TimeAdd---\n", test);
  SHOWTime(TimeAdd(TimeParse("2:30:40"), TimeParse("23:30:00")));

  if (++test > lasttest) return 0;
  printf("\n%d) TimeSubtract---\n", test);
  SHOWTime(TimeSubtract(TimeParse("2:30:00"), TimeParse("4:10:20")));

  return 0;
}
