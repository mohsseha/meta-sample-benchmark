import com.meta.spatial.sdk.gradle.BuildConstants

plugins {
    id("com.android.application")
    kotlin("android")
    id("com.meta.spatial.sdk.gradle.plugin")
}

android {
    namespace = "com.meta.object3dsample"
    compileSdk = BuildConstants.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.meta.object3dsample"
        minSdk = BuildConstants.MIN_SDK_VERSION
        targetSdk = BuildConstants.TARGET_SDK_VERSION
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Meta Spatial SDK
    implementation("com.meta.spatial:spatial-sdk:0.8.0")
    implementation("com.meta.spatial:spatial-sdk-ui:0.8.0")
}
