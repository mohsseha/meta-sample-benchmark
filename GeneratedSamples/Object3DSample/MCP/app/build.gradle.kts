plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // The TICKET.md file mentions a "Meta Spatial SDK Gradle Plugin".
    // I am assuming the plugin id is something like this.
    id("com.meta.spatial-sdk.gradle-plugin") version "0.8.0"
}

android {
    namespace = "com.meta.object3dsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.meta.object3dsample"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Meta Spatial SDK v0.8.0 dependencies.
    // I am assuming the dependency names are something like this.
    implementation("com.meta.spatial-sdk:core:0.8.0")
    implementation("com.meta.spatial-sdk:scene:0.8.0")
    implementation("com.meta.spatial-sdk:ui:0.8.0")
    implementation("com.meta.spatial-sdk:spatial-editor-support:0.8.0")

}
