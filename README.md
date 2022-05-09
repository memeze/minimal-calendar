# 📅 Minimal Calendar 
This calendar library is built with jetpack compose. Easy, simple, and minimal.  

![API](https://img.shields.io/badge/API-21+-blue) 
![GitHub Repo stars](https://img.shields.io/github/stars/memeze/minimal-calendar?color=yellow)

## Latest version
|Compose|Accompanist|Library|
|:-|:-|:-:|
|1.1.x|0.23.1|[![](https://img.shields.io/badge/JitPack-v1.0.4-brightgreen)](https://jitpack.io/#memeze/minimal-calendar)|
|1.2.x|0.24.6-alpha|[![](https://img.shields.io/badge/JitPack-v1.1.1-brightgreen)](https://jitpack.io/#memeze/minimal-calendar)|


## Setup
#### Step.1 
[Java 8+ API desugaring support (Android Gradle Plugin 4.0.0+)](https://developer.android.com/studio/write/java8-support#library-desugaring). 
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

#### Step.2
Add it in your `setting.gradle`:
```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ....
        maven { url "https://jitpack.io" }
    }
}
```

#### Step.3
Add the dependency your `build.gradle(app)`:
```groovy
dependencies {
    implementation 'com.github.memeze:minimal-calendar:<latest-version>'
}
```
> See [here](https://github.com/memeze/minimal-calendar#latest-version) for the `<latest-version>`


## Usage
```kotlin
fun MinimalCalendar(
    modifier: Modifier = Modifier,
    initDate: LocalDate = LocalDate.now(),
    calendarType: CalendarType = CalendarType.MONTH,
    calendarColors: MinimalCalendarColors = MinimalCalendarTheme.colors(),
    calendarConfig: MinimalCalendarConfig = MinimalCalendarConfig()
)
```
