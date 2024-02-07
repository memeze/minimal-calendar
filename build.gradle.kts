plugins {
    id("com.android.application") version "7.4.2" apply false
    id("com.android.library") version "7.4.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}