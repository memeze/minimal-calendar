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
        versionCode = ConfigData.VERSION_CODE
        versionName = ConfigData.VERSION_NAME

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

    implementation(Libs.Compose.material)
    implementation(Libs.Compose.animation)
    implementation(Libs.Compose.uiTooling)
    implementation(Libs.AndroidX.activityCompose)

    implementation(Libs.Accompanist.insets)
    implementation(Libs.Accompanist.insetsUi)
    implementation(Libs.Accompanist.systemUiController)
    implementation(Libs.Accompanist.appCompatTheme)
    implementation(Libs.Accompanist.pager)
    implementation(Libs.Accompanist.pagerIndicators)
    implementation(Libs.Accompanist.swipeRefresh)
    implementation(Libs.Accompanist.placeHolder)
    implementation(Libs.Accompanist.drawablePainter)
    implementation(Libs.Accompanist.flowLayout)
    implementation(Libs.Accompanist.permissions)
    implementation(Libs.Accompanist.navigationAnimation)
    implementation(Libs.Accompanist.navigationMaterial)

    coreLibraryDesugaring(Libs.Desugar.jdk) // Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)

    implementation(Libs.Lifecycle.runtime)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.AndroidTest.junit)
    androidTestImplementation(Libs.AndroidTest.espresso)
    androidTestImplementation(Libs.AndroidTest.compose)
}