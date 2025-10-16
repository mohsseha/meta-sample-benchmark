# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /tools/proguard/proguard-android.txt
# You can edit that file to add your own default rules.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If you use reflection, typically to serialize data classes, you may need this.
#-keepattributes Signature

# If you use Gson and reflection, you may need this.
#-keep class com.google.gson.examples.android.model.** { *; }
