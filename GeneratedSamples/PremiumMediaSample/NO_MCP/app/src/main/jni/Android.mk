LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := shaders
LOCAL_SRC_FILES := $(wildcard $(LOCAL_PATH)/../assets/shaders/*.glsl)
include $(BUILD_PREBUILT)
