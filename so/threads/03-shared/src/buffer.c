#include "buffer.h"

#include <string.h>
void buffer_process(buffer_t* buffer) {
  buffer->statistics.char_count = 0;
  buffer->statistics.digit_count = 0;
  buffer->statistics.letters_count = 0;
  char* tmp_char = buffer->to_process;
  while ((*tmp_char) != '\0') {
    if (
        ('A' <= *tmp_char && *tmp_char <= 'Z') ||
        ('a' <= *tmp_char && *tmp_char <= 'z'))
      buffer->statistics.letters_count++;
    if ('0' <= *tmp_char && *tmp_char <= '9')
      buffer->statistics.digit_count++;
    buffer->statistics.char_count++;
    tmp_char++;
  }
}

void buffer_print(buffer_t* buffer) {
  printf("%s -> length = %d, digit = %d, letter = %d\n",
         buffer->to_process,
         buffer->statistics.char_count,
         buffer->statistics.digit_count,
         buffer->statistics.letters_count);
}
void buffer_clear(buffer_t* buffer) {
  memset(buffer->to_process, 0, BUFFER_STR_MAX_SIZE);
  buffer->processed = false;
}