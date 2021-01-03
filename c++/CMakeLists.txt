# CMake 最低版本号要求
cmake_minimum_required (VERSION 3.17)

# 项目信息
project (c++)

set(CMAKE_CXX_STANDARD 20)

# 指定生成目标
add_executable(c++ main.cpp T234.cpp)