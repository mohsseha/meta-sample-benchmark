# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html
cmake_minimum_required(VERSION 3.22.1)

project("premiummediasample")

add_library(premiummediasample SHARED src/main/cpp/premiummediasample.cpp)

target_link_libraries(premiummediasample android log)
