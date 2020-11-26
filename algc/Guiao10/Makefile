# To compile all programs, run:
#   make
#
# Note that source files have .c extensions,
# for compatibility with codecheck, but they are actually pure C.
# 
# João Manuel Rodrigues, May 2020

#CC = gcc
#CXX = $(CC)

# Options for the C compiler. (-x c forces C language even for .ccp files)
CFLAGS += -x c -g -Wall
CPPFLAGS = $(CFLAGS)

TARGETS = BSTreeTest TAD4Test

all: $(TARGETS)

Time.o: Time.c Time.h

Date.o: Date.c Date.h

DateTime.o: DateTime.c DateTime.h

TimeInterval.o: TimeInterval.c TimeInterval.h DateTime.h Date.h Time.h

BSTree.o: BSTree.c BSTree.h

BSTreeTest.o: BSTreeTest.c BSTree.h

BSTreeTest: BSTreeTest.o BSTree.o

SchedulingSequence.o: SchedulingSequence.c SchedulingSequence.h \
            TimeInterval.h DateTime.h Date.h Time.h BSTree.h

TAD4Test.o: TAD4Test.c TimeInterval.h DateTime.h Date.h Time.h \
            SchedulingSequence.h

TAD4Test: TAD4Test.o TimeInterval.o DateTime.o Date.o Time.o \
            SchedulingSequence.o BSTree.o

clean:
	rm -f *.o
	rm -f $(TARGETS)


