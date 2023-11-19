// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val navVersion by extra ("2.6.0")

    repositories{
        google()
        mavenCentral()
        maven{
            url  = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
    }
    dependencies{
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
        classpath ("com.google.gms:google-services:4.4.0")
        classpath ("com.google.firebase:perf-plugin:1.4.2")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
    }
}
plugins {
    id("com.android.application") version "8.1.4" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.gms.google-services") version "4.3.15" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    kotlin("kapt") version "1.9.10"
}