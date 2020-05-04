# To compile all programs, run:
#   make
#
# To compile just TimeTest, e.g, run:
#   make TimeTest
#
# Note that source files have .c extensions,
# for compatibility with codecheck, but they are actually pure C.
# 
# JMR 2020

#CC = gcc
#CXX = $(CC)

# Options for the C compiler. (-x c forces C language even for .ccp files)
CFLAGS += -x c -g -Wall
CPPFLAGS = $(CFLAGS)

TARGETS = TimeTest DateTest TAD2Test

all: $(TARGETS)

TimeTest: TimeTest.o Time.o

TimeTest.o: TimeTest.c Time.h

Time.o: Time.c Time.h

DateTest: DateTest.o Date.o

DateTest.o: DateTest.c Date.h

Date.o: Date.c Date.h

DateTime.o: DateTime.c DateTime.h

TimeInterval.o: TimeInterval.c TimeInterval.h DateTime.h Date.h Time.h

SchedulingSequence.o: SchedulingSequence.c SchedulingSequence.h \
            TimeInterval.h DateTime.h Date.h Time.h

TAD2Test.o: TAD2Test.c TimeInterval.h DateTime.h Date.h Time.h \
            SchedulingSequence.h

TAD2Test: TAD2Test.o TimeInterval.o DateTime.o Date.o Time.o \
            SchedulingSequence.o

clean:
	rm -f *.o
	rm -f $(TARGETS)


