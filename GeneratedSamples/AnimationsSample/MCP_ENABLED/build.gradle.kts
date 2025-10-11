
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.kotlin) apply false
    alias(libs.plugins.kotlin.jvm) apply false
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
