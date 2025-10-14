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
        // Meta Spatial SDK repository
        maven { url = uri("https://s3.amazonaws.com/downloads.metaspatial.com/releases/v0.8.0/") }
    }
}
rootProject.name = "MediaPlayerSample"
include(":app")
