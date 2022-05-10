# 📅 Minimal Calendar 
This calendar library is built with jetpack compose. Easy, simple, and minimal.  

![API](https://img.shields.io/badge/API-21+-blue) 
![GitHub Repo stars](https://img.shields.io/github/stars/memeze/minimal-calendar?color=yellow)

## Latest version
The stable version of the library is the version that uses `Compose 1.1.x`, and it can be used as follows to cope with the `Compose 1.2.x` version.
|Compose      |Library                                                                                                    |
|:------------|:---------------------------------------------------------------------------------------------------------:|
|1.1.x        |[![](https://img.shields.io/badge/JitPack-v1.0.5-brightgreen)](https://jitpack.io/#memeze/minimal-calendar)|
|1.2.x (alpha)|[![](https://img.shields.io/badge/JitPack-v1.1.2-brightgreen)](https://jitpack.io/#memeze/minimal-calendar)|


## Setup
👉 _**Step.1**_ [Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)](https://developer.android.com/studio/write/java8-support#library-desugaring).  
Include the following in your app module’s `build.gradle(app)` file:
```groovy
android {
    ....
    compileOptions {
        coreLibraryDesugaringEnabled true
    }
}

dependencies {
    coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:<latest-version>'
}
```
> See [here](https://mvnrepository.com/artifact/com.android.tools/desugar_jdk_libs) for the `<latest-version>`

</br>

👉 _**Step.2**_ Add it in your `setting.gradle`:
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ....
        maven { url "https://jitpack.io" }
    }
}
```

</br>

👉 **Step.3** _Add the dependency your `build.gradle(app)`:_
```groovy
dependencies {
    implementation 'com.github.memeze:minimal-calendar:<latest-version>'
}
```
> See [here](https://github.com/memeze/minimal-calendar#latest-version) for the `<latest-version>`

</br>

## Usage
```kotlin
fun MinimalCalendar(
    modifier: Modifier = Modifier,
    initDate: LocalDate = LocalDate.now(),
    onSelectDate: (date: LocalDate) -> Unit,
    calendarColors: MinimalCalendarColors = MinimalCalendarTheme.colors(),
    calendarConfig: MinimalCalendarConfig = MinimalCalendarConfig()
)
```
