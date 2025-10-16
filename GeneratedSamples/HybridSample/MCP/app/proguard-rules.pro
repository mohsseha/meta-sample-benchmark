# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /usr/local/google/android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If you use reflection to access classes in shrinking code, you need
# to include keep options here reflecting that code. That way, the
# shrinker will know not to remove those classes.
-keep class com.meta.spatial.** { *; }
-keep interface com.meta.spatial.** { *; }
