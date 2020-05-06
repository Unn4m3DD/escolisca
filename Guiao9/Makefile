# To compile all programs, run:
#   make
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

TARGETS = SortedListTest1 SortedListTest2 TAD3Test

all: $(TARGETS)

Time.o: Time.c Time.h

Date.o: Date.c Date.h

DateTime.o: DateTime.c DateTime.h

TimeInterval.o: TimeInterval.c TimeInterval.h DateTime.h Date.h Time.h

SortedList.o: SortedList.c SortedList.h

SortedListTest1.o: SortedListTest1.c SortedList.h

SortedListTest1: SortedListTest1.o SortedList.o

SortedListTest2.o: SortedListTest2.c Date.h SortedList.h

SortedListTest2: SortedListTest2.o SortedList.o Date.o

SchedulingSequence.o: SchedulingSequence.c SchedulingSequence.h \
            TimeInterval.h DateTime.h Date.h Time.h SortedList.h

TAD3Test.o: TAD3Test.c TimeInterval.h DateTime.h Date.h Time.h \
            SchedulingSequence.h

TAD3Test: TAD3Test.o TimeInterval.o DateTime.o Date.o Time.o \
            SchedulingSequence.o SortedList.o

clean:
	rm -f *.o
	rm -f $(TARGETS)


