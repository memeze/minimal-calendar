/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.GRADLE_PLUGIN}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}" }
}

/**
 * To defines dependencies
 */
object Libs {
    object AndroidX {
        val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.APPCOMPAT}" }
        val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.DATASTORE}" }
        val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}" }
        val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.ACTIVITY}" }
        val work by lazy { "androidx.work:work-runtime-ktx:${Versions.WORK}" }
    }

    object Accompanist {
        val insets by lazy { "com.google.accompanist:accompanist-insets:${Versions.ACCOMPANIST}" }
        val insetsUi by lazy { "com.google.accompanist:accompanist-insets-ui:${Versions.ACCOMPANIST}" }
        val systemUiController by lazy { "com.google.accompanist:accompanist-systemuicontroller:${Versions.ACCOMPANIST}" }
        val appCompatTheme by lazy { "com.google.accompanist:accompanist-appcompat-theme:${Versions.ACCOMPANIST}" }
        val pager by lazy { "com.google.accompanist:accompanist-pager:${Versions.ACCOMPANIST}" }
        val pagerIndicators by lazy { "com.google.accompanist:accompanist-pager-indicators:${Versions.ACCOMPANIST}" }
        val swipeRefresh by lazy { "com.google.accompanist:accompanist-swiperefresh:${Versions.ACCOMPANIST}" }
        val placeHolder by lazy { "com.google.accompanist:accompanist-placeholder-material:${Versions.ACCOMPANIST}" }
        val drawablePainter by lazy { "com.google.accompanist:accompanist-drawablepainter:${Versions.ACCOMPANIST}" }
        val flowLayout by lazy { "com.google.accompanist:accompanist-flowlayout:${Versions.ACCOMPANIST}" }
        val permissions by lazy { "com.google.accompanist:accompanist-permissions:${Versions.ACCOMPANIST}" }
        val navigationAnimation by lazy { "com.google.accompanist:accompanist-navigation-animation:${Versions.ACCOMPANIST}" }
        val navigationMaterial by lazy { "com.google.accompanist:accompanist-navigation-material:${Versions.ACCOMPANIST}" }
    }

    object Compose {
        val material by lazy { "androidx.compose.material:material:${Versions.COMPOSE}" }
        val animation by lazy { "androidx.compose.animation:animation:${Versions.COMPOSE}" }
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}" }
    }

    object Core {
        val ktx by lazy { "androidx.core:core-ktx:${Versions.CORE_KTX}" }
        val splash by lazy { "androidx.core:core-splashscreen:${Versions.SPLASH}" }
    }

    object Coil {
        val compose by lazy { "io.coil-kt:coil-compose:${Versions.COIL}" }
    }

    object Desugar {
        val jdk by lazy { "com.android.tools:desugar_jdk_libs:1.1.5" }
    }

    object Firebase {
        val bom by lazy { "com.google.firebase:firebase-bom:${Versions.FIREBASE}" }
        val analytics by lazy { "com.google.firebase:firebase-analytics-ktx" }
        val auth by lazy { "com.google.firebase:firebase-auth-ktx" }
    }

    object Google {
        val material by lazy { "com.google.android.material:material:${Versions.MATERIAL}" }
        val playServiceAuth by lazy { "com.google.android.gms:play-services-auth:${Versions.PLAY_SERVICE_AUTH}" }
    }

    object Hilt {
        val android by lazy { "com.google.dagger:hilt-android:${Versions.HILT}" }
        val androidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.HILT}" }
        val workManager by lazy { "androidx.hilt:hilt-work:${Versions.HILT_JETPACK}" }
        val compiler by lazy { "androidx.hilt:hilt-compiler:${Versions.HILT_JETPACK}" }
        val navigation by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.HILT_JETPACK}" }
    }

    object Kotlinx {
        val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}" }
    }

    object Lifecycle {
        val viewmodel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}" }
        val viewmodelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFECYCLE}" }
        val livedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}" }
        val runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}" }
        val viewmodelSavedState by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFECYCLE}" }
        val compiler by lazy { "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}" }
        val common by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE}" }
    }

    object Navigation {
        val fragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}" }
        val ui by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}" }
        val compose by lazy { "androidx.navigation:navigation-compose:${Versions.NAVIGATION}" }
        val testing by lazy { "androidx.navigation:navigation-testing:${Versions.NAVIGATION}" }
    }

    object Room {
        val ktx by lazy { "androidx.room:room-ktx:${Versions.ROOM}" }
        val runtime by lazy { "androidx.room:room-runtime:${Versions.ROOM}" }
        val compiler by lazy { "androidx.room:room-compiler:${Versions.ROOM}" }
    }

    object Test {
        val junit by lazy { "junit:junit:${Versions.JUNIT}" }
        val room by lazy { "androidx.room:room-testing:${Versions.ROOM}" }
    }

    object AndroidTest {
        val junit by lazy { "androidx.test.ext:junit:1.1.3" }
        val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
        val compose by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}" }
    }

    object Network {
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}" }
        val retrofitConverterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}" }
        val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}" }
        val okhttpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}" }
    }

    val timber by lazy { "com.jakewharton.timber:timber:${Versions.TIMBER}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}" }
}