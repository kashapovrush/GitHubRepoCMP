plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
}

buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
//        classpath ("com.android.tools.build:gradle:7.0.2")
//        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath ("org.jetbrains.kotlin:kotlin-serialization:1.9.22")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
