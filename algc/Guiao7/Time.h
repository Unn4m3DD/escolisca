#ifndef _TIME_
#define _TIME_

typedef int Time;

extern const Time TimeMIN, TimeMAX, TimeERR;

Time TimeCreate(int hh, int mm, int ss);
int TimeIsValid(int hh, int mm, int ss);
int TimeGetHH(Time t);
int TimeGetMM(Time t);
int TimeGetSS(Time t);
int TimeGetSeconds(Time t);
char* TimeFormat(Time t);
Time TimeParse(const char* str);
int TimeCompare(Time a, Time b);
Time TimeAdd(Time a, Time b);
Time TimeSubtract(Time a, Time b);

#endif
