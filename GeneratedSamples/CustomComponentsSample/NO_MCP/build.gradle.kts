
import java.net.URI

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.meta.xr.gradle.plugin")
}

android {
    namespace = "com.meta.spatial.sdk.sample.customcomponents"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.meta.spatial.sdk.sample.customcomponents"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("com.google.android.material:material:1.11.0")
    implementation(platform("com.meta.xr:sdk-bom:0.8.0"))
    implementation("com.meta.xr:sdk")
}

metaSpatial {
    debug.set(true)
    verbose.set(true)
}
