plugins {
    id("kotlin-android")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigData.COMPILE_SDK

    defaultConfig {
        applicationId = ConfigData.APPLICATION_ID
        minSdk = ConfigData.MIN_SDK
        targetSdk = ConfigData.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Libs.Core.ktx)

    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.activityCompose)

    implementation(Libs.Compose.material)
    implementation(Libs.Compose.animation)
    implementation(Libs.Compose.uiTooling)

    implementation(Libs.Lifecycle.runtime)
    implementation(project(mapOf("path" to ":minimalcalendar")))

    coreLibraryDesugaring(Libs.Desugar.jdk) // Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)
//    implementation("com.github.memeze:minimal-calendar:1.0.0")

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.AndroidTest.junit)
    androidTestImplementation(Libs.AndroidTest.espresso)
    androidTestImplementation(Libs.AndroidTest.compose)
}