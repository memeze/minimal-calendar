# Minimal Calendar 📅
This calendar library is built with jetpack compose. Easy, simple, and minimal.  

![API](https://img.shields.io/badge/API-21%2B-green)
![GitHub Repo stars](https://img.shields.io/github/stars/memeze/minimal-calendar?color=yellow)


## Setup
![JitPack](https://img.shields.io/jitpack/v/github/memeze/minimal-calendar)

Groovy DSL
```groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```
```groovy
dependencies {
    coreLibraryDesugaring 'com.android.tools:desugar_jdk_libs:1.1.5'
    implementation 'com.github.memeze:minimal-calendar:1.0.0'
}
```
Kotlin DSL
```kotlin
repositories {
    ...
    maven { url = uri("https://jitpack.io") }
}
```
```kotlin
dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    implementation("com.github.memeze:minimal-calendar:1.0.0")
}
```

## Usage
```kotlin
MinimalCalendar()
```
