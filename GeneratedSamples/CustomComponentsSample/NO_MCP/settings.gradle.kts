
pluginManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("httpshttps://s01.oss.sonatype.org/content/repositories/releases/")
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("httpshttps://s01.oss.sonatype.org/content/repositories/releases/")
        }
    }
}

rootProject.name = "CustomComponentsSample"
include(":app")
