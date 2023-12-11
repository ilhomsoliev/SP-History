plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.plugin.serialization") apply true
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    kotlin("kapt")

}
baseConfig()

compose()

android {

    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation("com.github.GrenderG:Toasty:1.5.2")
    implementation("com.google.android.material:material:1.10.0")
    androidBase()
    compose()
    ktor()
    dataStore()
    jackson()
    room()
    kapt("androidx.room:room-compiler:2.6.0")

    customactivityoncrash()
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")
    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")
    implementation("io.coil-kt:coil-gif:2.2.2")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    implementation("androidx.browser:browser:1.6.0")
    // GSON
    implementation("com.google.code.gson:gson:2.10.1")

}

