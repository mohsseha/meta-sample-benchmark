
pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://s3.amazonaws.com/downloads.metaspatial.com/releases/v0.8.0")
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://s3.amazonaws.com/downloads.metaspatial.com/releases/v0.8.0")
        }
    }
}
rootProject.name = "PhysicsSample"
include(":app")
