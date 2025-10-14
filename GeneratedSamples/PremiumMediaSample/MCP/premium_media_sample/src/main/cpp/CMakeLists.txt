cmake_minimum_required(VERSION 3.18.1)

project("premiummediasample")

add_library(
    premiummediasample
    SHARED
    premiummediasample.cpp
)

target_link_libraries(
    premiummediasample
    android
    log
)
