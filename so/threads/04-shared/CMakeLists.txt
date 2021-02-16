cmake_minimum_required (VERSION 2.8.12)
project (shared)
add_executable (program04 
  src/Main.cpp
  src/StringGen.cpp
  src/Queue.cpp
)
target_link_libraries(program04 
  -lpthread
)
include_directories(program04 include/)
