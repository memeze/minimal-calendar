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
    namespace = "com.memeze.sample"
}

dependencies {
    implementation(project(":minimalcalendar"))

    implementation(Libs.Core.ktx)
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

    implementation(Libs.Lifecycle.runtime)
    coreLibraryDesugaring(Libs.Desugar.jdk) // Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)
    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.AndroidTest.junit)
    androidTestImplementation(Libs.AndroidTest.espresso)
    androidTestImplementation(Libs.AndroidTest.compose)
}