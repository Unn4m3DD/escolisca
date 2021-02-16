#include "StringGen.h"

void GenerateRandomString(int length, char* destination) {
  static const char alphanum[] =
      " 0123456789"
      "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      "abcdefghijklmnopqrstuvwxyz";
  for (int i = 0; i < length - 1; ++i)
    destination[i] = alphanum[rand() % (sizeof(alphanum) - 1)];
  destination[length - 1] = '\0';
}