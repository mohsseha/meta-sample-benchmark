pluginManagement {
    repositories {
        google()
        mavenCentral()
        // Meta Spatial SDK repository
        maven { url = uri("https://s3.amazonaws.com/mcp.vrs.meta.com/release") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Meta Spatial SDK repository
        maven { url = uri("https://s3.amazonaws.com/mcp.vrs.meta.com/release") }
    }
}
rootProject.name = "StarterSample"
include(":app")
