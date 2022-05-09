plugins {
    id(BuildPlugins.application) version Versions.GRADLE_PLUGIN apply false
    id(BuildPlugins.library) version Versions.GRADLE_PLUGIN apply false
    id(BuildPlugins.kotlin) version Versions.KOTLIN apply false
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}