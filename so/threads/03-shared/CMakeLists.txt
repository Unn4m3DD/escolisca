cmake_minimum_required (VERSION 2.8.11)
project (shared)
add_executable (program03 
  src/main.c 
  src/queue.c 
  src/buffer.c
  src/client.c
  src/server.c
)
target_link_libraries(program03 
  -lpthread
)
include_directories(program03 include/)
