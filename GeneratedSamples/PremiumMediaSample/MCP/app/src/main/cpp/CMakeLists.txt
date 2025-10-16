
cmake_minimum_required(VERSION 3.22.1)

project("premiummediasample")

# Add the shader files to the build
file(GLOB_RECURSE SHADERS "src/main/assets/shaders/*.glsl")

add_library(
    premiummediasample
    SHARED
    ${SHADERS}
)

target_link_libraries(
    premiummediasample
    android
    log
)
