# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# by Android build tools.
# You can find general ProGuard rules for Android here:
# http://proguard.sourceforge.net/Android.html#configuring
#
# Add any project specific keep options here:
#
# If you use reflection inhibitors, keep the interfaces:
#-keep interface com.google.vending.licensing.ILicensingService
-keep class com.meta.xr.sdk.common.** { *; }
-keep interface com.meta.xr.sdk.common.** { *; }
