plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.meta.spatial-sdk.gradle") version "0.8.0"
}

android {
    namespace = "com.meta.mixedreality.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.meta.mixedreality.app"
        minSdk = 29
        targetSdk = 34
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
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Meta Spatial SDK
    implementation("com.meta.spatial-sdk:sdk:0.8.0")
    implementation("com.meta.spatial-sdk:mruk:0.8.0")
    implementation("com.meta.spatial-sdk:physics:0.8.0")

    // jMonkeyEngine Physics
    implementation("org.jmonkeyengine:jme3-bullet:3.6.1-stable")
}

spatialSdk {
    // Enable physics features
    features {
        physics = true
    }
}
