plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.memeze"
            artifactId = "minimalcalendar"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
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
}

dependencies {

    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.activityCompose)

    implementation(Libs.Compose.material)
    implementation(Libs.Compose.animation)
    implementation(Libs.Compose.uiTooling)

    implementation(Libs.Accompanist.pager)

    coreLibraryDesugaring(Libs.Desugar.jdk) // Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.AndroidTest.junit)
    androidTestImplementation(Libs.AndroidTest.espresso)
    androidTestImplementation(Libs.AndroidTest.compose)
}