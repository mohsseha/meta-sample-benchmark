
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/husainal-mohssen/Android/Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If you use reflection to access classes in shrinking code...
#-keep class com.example.myClass
#-keep class my.package.MyClass
# ...and keep the members you need them to.
#-keepclassmembers class com.example.myClass {
#   public <init>();
#}

-keep class com.meta.** { *; }
-keep interface com.meta.** { *; }
-keep class org.joml.** { *; }
-keep class kotlin.Metadata { *; }
-keepclassmembers class ** {
    @kotlin.Metadata
    *;
}
-keep class * extends androidx.versionedparcelable.VersionedParcelable
-keepclassmembers class androidx.core.app.ComponentActivity {
    *;
}
-keep class androidx.core.app.ComponentActivity$* {
    *;
}
-keep class * extends java.lang.annotation.Annotation
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes InnerClasses
-keepattributes EnclosingMethod
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations
-dontwarn org.joml.**
-dontwarn com.google.flatbuffers.**
-dontwarn com.meta.**
-dontwarn javax.annotation.**
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn org.jetbrains.annotations.NotNull
-dontwarn org.jetbrains.annotations.Nullable
-dontwarn kotlin.jvm.internal.Intrinsics

# -keep public class my.package.MyClass
# -keep public interface my.package.MyInterface
# -keep @my.package.MyAnnotation class *
# -keepclassmembers class my.package.MyClass {
#    <fields>
#    <methods>
# }
