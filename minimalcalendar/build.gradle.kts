plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    compileSdk = ConfigData.COMPILE_SDK

    defaultConfig {
        minSdk = ConfigData.MIN_SDK
        targetSdk = ConfigData.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs.plus(
            listOf(
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"
            )
        )
    }

    publishing {
        multipleVariants {
            withSourcesJar()
            withJavadocJar()
            allVariants()
        }
    }
}

dependencies {

    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.activityCompose)

    val composeBom = platform(Libs.Compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(Libs.Compose.material2)
    implementation(Libs.Compose.uiToolingPreview)
    debugImplementation(Libs.Compose.uiTooling)
    androidTestImplementation(Libs.Compose.uiTestJunit)
    debugImplementation(Libs.Compose.uiTestManifest)

    implementation(Libs.Accompanist.pager)

    coreLibraryDesugaring(Libs.Desugar.jdk) // Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.AndroidTest.junit)
    androidTestImplementation(Libs.AndroidTest.espresso)
    androidTestImplementation(Libs.AndroidTest.compose)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.memeze"
                artifactId = "minimalcalendar"
                version = "1.0.9"
            }
        }
    }
}
