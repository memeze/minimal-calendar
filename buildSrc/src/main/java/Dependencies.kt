/**
 * To define plugins
 */
object BuildPlugins {
    val application by lazy { "com.android.application" }
    val library by lazy { "com.android.library" }
    val kotlin by lazy { "org.jetbrains.kotlin.android" }
}

/**
 * To defines dependencies
 */
object Libs {
    object AndroidX {
        val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.APPCOMPAT}" }
        val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.ACTIVITY}" }
    }

    object Accompanist {
        val pager by lazy { "com.google.accompanist:accompanist-pager:${Versions.ACCOMPANIST}" }
    }

    object Compose {
        val material by lazy { "androidx.compose.material:material:${Versions.COMPOSE}" }
        val animation by lazy { "androidx.compose.animation:animation:${Versions.COMPOSE}" }
        val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}" }
    }

    object Core {
        val ktx by lazy { "androidx.core:core-ktx:${Versions.CORE_KTX}" }
    }

    object Desugar {
        val jdk by lazy { "com.android.tools:desugar_jdk_libs:1.1.5" }
    }

    object Lifecycle {
        val runtime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}" }
    }

    object Test {
        val junit by lazy { "junit:junit:${Versions.JUNIT}" }
    }

    object AndroidTest {
        val junit by lazy { "androidx.test.ext:junit:1.1.3" }
        val espresso by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
        val compose by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.COMPOSE}" }
    }
}