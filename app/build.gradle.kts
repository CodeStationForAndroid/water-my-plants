plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.abaferastech.watermyplants"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.abaferastech.watermyplants"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(Deps.activityCompose)
    implementation(platform(Deps.composeBom))
    implementation(Deps.composeUI)
//    implementation(Deps.composeUIGraphics)
    implementation(Deps.composeUIToolingPreview)
    implementation(Deps.composeMaterial3)
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.junitExt)
    androidTestImplementation(Deps.espresso)
//    androidTestImplementation(platform(Deps.composeUIGraphics))
//    androidTestImplementation(Deps.composeUIGraphics)
//    debugImplementation(Deps.composeUIGraphics)
//    debugImplementation(Deps.composeUIGraphics)
    androidTestImplementation(platform(Deps.composeBom))
    androidTestImplementation(Deps.composeUITestJunit4)
    debugImplementation(Deps.composeUITooling)
    debugImplementation(Deps.composeUITestManifest)
    implementation(Deps.appCompat)
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)
    implementation(Deps.hiltNavigationCompose)
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConvertoer)
    implementation(Deps.okhttp3Logging)
    implementation(Deps.lifecycleViewModelKts)
    implementation(Deps.lifecycleViewModelCompose)
    implementation(Deps.lifecycleRunTimeCompose)
    implementation(Deps.lifecycleSavedState)
    implementation(Deps.lifecycleCommon)
    implementation(Deps.lifecycleService)
    implementation(Deps.lifecycleProcess)
    testImplementation(Deps.lifecycleRuntimeTesting)
    testImplementation(Deps.coroutineArchTest)
    androidTestImplementation(Deps.coroutineArchAndroidTest)
}
kapt {
    correctErrorTypes = true
}