pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        // Assuming Meta hosts a Maven repository for the Spatial SDK plugin
        maven { url = uri("https://s3.amazonaws.com/downloads.metaspatial.com/releases/maven") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Assuming Meta hosts a Maven repository for the Spatial SDK artifacts
        maven { url = uri("https://s3.amazonaws.com/downloads.metaspatial.com/releases/maven") }
    }
}

rootProject.name = "StarterSample"
include(":app")
