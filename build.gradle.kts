
plugins {
    id("com.google.gms.google-services") version "4.4.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}


buildscript {
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        google()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.0")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.4")

    }
}