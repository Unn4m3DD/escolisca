#include "Time.h"

#include <assert.h>
#include <stdio.h>

#define TimeFULLDAY ((Time)24 * 60 * 60)
const Time TimeMIN = (Time)0;
const Time TimeMAX = (Time)(TimeFULLDAY - 1);
const Time TimeERR = (Time)(-1);

static int invariant(Time t) { return TimeMIN <= t && t <= TimeMAX; }

Time TimeCreate(int hh, int mm, int ss) {
  assert(TimeIsValid(hh, mm, ss));
  Time t = hh * 60 * 60 + mm * 60 + ss;
  assert(invariant(t));
  return t;
}

int TimeIsValid(int hh, int mm, int ss) {
  return 0 <= hh && hh < 24 && 0 <= mm && mm < 60 && 0 <= ss && ss < 60;
}

int TimeGetHH(Time t) { return t / 60 / 60 % 24; }

int TimeGetMM(Time t) { return t / 60 % 60; }

int TimeGetSS(Time t) { return t % 60; }

int TimeGetSeconds(Time t) { return t; }

static char str[9];

char* TimeFormat(Time t) {
  snprintf(str, sizeof(str), "%02d:%02d:%02d", TimeGetHH(t), TimeGetMM(t),
           TimeGetSS(t));
  return str;
}

Time TimeParse(const char* str) {
  Time t = TimeERR;
  int hh, mm, ss;
  ss = 0;

  int n = sscanf(str, "%02d:%02d:%02d", &hh, &mm, &ss);
  if (n < 3) n = sscanf(str, "%02d:%02d", &hh, &mm);
  if (TimeIsValid(hh, mm, ss)) {
    t = TimeCreate(hh, mm, ss);
  }
  assert(t == TimeERR || invariant(t));
  return t;
}

int TimeCompare(Time a, Time b) { return a > b ? 1 : a == b ? 0 : -1; }

Time TimeAdd(Time a, Time b) {
  Time t = (a + b) % TimeFULLDAY;
  assert(invariant(t));
  return t;
}

Time TimeSubtract(Time a, Time b) {
  Time t = (a - b) % TimeFULLDAY;
  if (t < 0) t = TimeFULLDAY + t;
  assert(invariant(t));
  return t;
}