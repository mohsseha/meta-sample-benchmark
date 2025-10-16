
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Add the Meta maven repository
        maven { url = uri("https://s3.amazonaws.com/downloads.metaspatial.io/android/maven") }
    }
}
rootProject.name = "MixedRealityPhysicsSample"
include(":app")
