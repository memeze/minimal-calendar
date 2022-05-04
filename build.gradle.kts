buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}